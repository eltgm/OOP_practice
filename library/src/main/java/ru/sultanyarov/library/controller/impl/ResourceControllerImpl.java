package ru.sultanyarov.library.controller.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sultanyarov.library.controller.ResourceController;
import ru.sultanyarov.library.domain.CarrierType;
import ru.sultanyarov.library.domain.Resource;
import ru.sultanyarov.library.dto.ResourceDto;
import ru.sultanyarov.library.service.ResourceService;

import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.sultanyarov.library.mapper.ResourceMapper.*;

@Controller
public class ResourceControllerImpl implements ResourceController {
    private final ResourceService resourceService;

    public ResourceControllerImpl(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/")
    public String moveToIndex() {
        return "redirect:/library";
    }

    @Override
    @GetMapping("/library")
    public String moveToResources(Model model) {
        model.addAttribute("resources", mapResourcesToResourcesDto(resourceService.getAllAvailableResources()));
        model.addAttribute("authorities", SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .map((Function<GrantedAuthority, String>) GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
        );
        return "library";
    }

    @GetMapping("/library/edit/{id}/{carrierType}")
    public String getUpdateResourcePage(Model model, @PathVariable String id, @PathVariable String carrierType) {
        CarrierType carrierTypeEnum = CarrierType.valueOf(carrierType);
        Resource resourceById = resourceService.getResourceById(id, carrierTypeEnum);
        ResourceDto resourceDto = mapResourceDtoToDomain(carrierTypeEnum, resourceById);
        model.addAttribute("resource", resourceDto);

        return "resourceEdit";
    }

    @Override
    @PostMapping("/library/edit")
    public String editResource(Model model, ResourceDto resource) {
        resourceService.editResource(mapDtoToDomainResource(resource));
        return "redirect:/library";
    }

    @Override
    @GetMapping("/library/delete/{id}")
    public String deleteResource(Model model, @PathVariable String id) {
        resourceService.deleteResourceById(id);
        return "redirect:/library";
    }

    @Override
    public String createResource(Model model) {
        return null;
    }

    @Override
    @GetMapping("/library/reviews/{id}")
    public String getResourceReviews(Model model, @PathVariable String id) {
        model.addAttribute("reviews", resourceService.getAllByResource_Id(id));
        return "reviews";
    }
}
