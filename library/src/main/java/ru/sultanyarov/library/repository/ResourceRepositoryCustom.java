package ru.sultanyarov.library.repository;

import ru.sultanyarov.library.domain.CarrierType;
import ru.sultanyarov.library.domain.Resource;

import java.util.List;

public interface ResourceRepositoryCustom {
    List<Resource> findAllByCarrierType(CarrierType carrierType);

    Resource findResourceById(String id, CarrierType carrierType);

    void updateResource(Resource resource);
}
