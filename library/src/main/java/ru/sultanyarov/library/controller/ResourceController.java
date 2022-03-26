package ru.sultanyarov.library.controller;

import org.springframework.ui.Model;
import ru.sultanyarov.library.dto.ResourceDto;

public interface ResourceController {
    String moveToResources(Model model);

    String editResource(Model model, ResourceDto resource);

    String deleteResource(Model model, String id);

    String createResource(Model model);

    String getResourceReviews(Model model, String id);
}
