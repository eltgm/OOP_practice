package ru.sultanyarov.library.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sultanyarov.library.domain.*;
import ru.sultanyarov.library.repository.ClientRepository;
import ru.sultanyarov.library.repository.ResourceRepository;
import ru.sultanyarov.library.service.ClientsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;
import static ru.sultanyarov.library.mapper.ResourceMapper.mapDigitalResourceToResourceDto;
import static ru.sultanyarov.library.mapper.ResourceMapper.mapPaperResourceToResourceDto;

@Service
public class ClientsServiceImpl implements ClientsService, UserDetailsService {
    private final ClientRepository clientRepository;
    private final ResourceRepository resourceRepository;

    public ClientsServiceImpl(ClientRepository clientRepository, ResourceRepository resourceRepository) {
        this.clientRepository = clientRepository;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource takeResource(String resourceId) {
        var resource = getResource(resourceId);
        if (resource == null) return null;

        resource.setAvailability(false);
        resourceRepository.save(resource);

        return resource;
    }

    @Override
    public boolean returnResource(Resource resource) {
        resource.setAvailability(true);
        resourceRepository.save(resource);
        return true;
    }

    @Override
    public boolean leaveFeedback(String resourceId, String comment, int rate) {
        var reader = (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var resource = getResource(resourceId);
        if (resource == null) {
            return false;
        }
        List<Review> resourceReviews = resource.getResourceReviews();
        resourceReviews.add(Review.builder()
                .comment(comment)
                .rate(rate)
                .reader(reader)
                .resource(resource.getCarrierType() == CarrierType.PAPER ?
                        mapPaperResourceToResourceDto((PaperCarrier) resource) :
                        mapDigitalResourceToResourceDto((DigitalCarrier) resource))
                .build());
        resource.setResourceReviews(resourceReviews);
        resourceRepository.save(resource);

        return true;
    }

    @Override
    public boolean deleteAccount() {
        var reader = (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        reader.setBlocked(true);
        clientRepository.save(reader);

        return true;
    }

    @Override
    public List<Reader> getAllClients() {
        List<Reader> client = clientRepository.findAll();
        for (Reader reader : client) {
            if (isEmpty(reader.getResourcesInUse())) continue;

            List<Resource> updatedResource =
                    reader.getResourcesInUse()
                            .stream()
                            .map(clientResourceDto -> resourceRepository.findResourceById(clientResourceDto.getId(), clientResourceDto.getCarrierType()))
                            .collect(Collectors.toList());
            reader.setResourcesInUseDto(updatedResource);
        }

        return client;
    }

    private Resource getResource(String resourceId) {
        Optional<Resource> resourceOptional = resourceRepository.findById(resourceId);
        if (resourceOptional.isEmpty()) {
            return null;
        }
        return resourceOptional.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository.findUserByName(username);
    }
}
