package ru.sultanyarov.library.service;

import ru.sultanyarov.library.domain.*;

import java.util.List;

public interface ResourceService {
    List<Resource> getAllAvailableResources();

    List<Resource> getAllResourcesByClientId(String clientId);

    void editResource(Resource resource);

    boolean deleteResourceById(String id);

    Resource getResourceById(String resourceId, CarrierType carrierType);

    List<Review> getAllByResource_Id(String resourceId);
}
