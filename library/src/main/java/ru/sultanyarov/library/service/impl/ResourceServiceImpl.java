package ru.sultanyarov.library.service.impl;

import org.springframework.stereotype.Service;
import ru.sultanyarov.library.domain.*;
import ru.sultanyarov.library.repository.ClientRepository;
import ru.sultanyarov.library.repository.ResourceRepository;
import ru.sultanyarov.library.repository.ReviewRepository;
import ru.sultanyarov.library.service.ResourceService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class ResourceServiceImpl implements ResourceService {
    private final ResourceRepository resourceRepository;
    private final ClientRepository clientRepository;
    private final ReviewRepository reviewRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository,
                               ClientRepository clientRepository,
                               ReviewRepository reviewRepository) {
        this.resourceRepository = resourceRepository;
        this.clientRepository = clientRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Resource> getAllAvailableResources() {
        var resources = new ArrayList<Resource>();
        resources.addAll(resourceRepository.findAllByCarrierType(CarrierType.PAPER));
        resources.addAll(resourceRepository.findAllByCarrierType(CarrierType.DIGITAL));

        for (Resource resource : resources) {
            List<Review> resourceReviews = resource.getResourceReviews();

            if (isEmpty(resourceReviews)) {
                continue;
            }
            double rateAverage = resourceReviews.stream()
                    .mapToDouble(Review::getRate)
                    .average()
                    .orElse(0);
            resource.setAvgRate(rateAverage);
        }

        return resources;
    }

    @Override
    public List<Resource> getAllResourcesByClientId(String clientId) {
        return clientRepository.findResourcesInUseById(clientId)
                .getResourcesInUse()
                .stream()
                .map(clientResourceDto -> resourceRepository.findById(clientResourceDto.getId()).orElse(null))
                .collect(Collectors.toList());
    }

    @Override
    public void editResource(Resource updatedResource) {
        resourceRepository.updateResource(updatedResource);
    }

    @Override
    public boolean deleteResourceById(String id) {
        resourceRepository.deleteById(id);
        return true;
    }

    @Override
    public Resource getResourceById(String resourceId, CarrierType carrierType) {
        return resourceRepository.findResourceById(resourceId, carrierType);
    }

    @Override
    public List<Review> getAllByResource_Id(String resourceId) {
        return reviewRepository.findAllByResource_Id(resourceId);
    }
}
