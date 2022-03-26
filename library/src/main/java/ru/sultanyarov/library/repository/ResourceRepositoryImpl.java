package ru.sultanyarov.library.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.sultanyarov.library.domain.CarrierType;
import ru.sultanyarov.library.domain.Resource;

import java.util.List;

import static ru.sultanyarov.library.mongock.DatabaseChangelog.RESOURCE_COLLECTION;

public class ResourceRepositoryImpl implements ResourceRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public ResourceRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Resource> findAllByCarrierType(CarrierType carrierType) {
        var resourceQuery = new Query(Criteria
                .where("carrierType")
                .is(carrierType));
        return (List<Resource>) mongoTemplate.find(resourceQuery, carrierType.getCarrierResource(), RESOURCE_COLLECTION);
    }

    @Override
    public Resource findResourceById(String id, CarrierType carrierType) {
        var resourceQuery = new Query(Criteria
                .where("carrierType")
                .is(carrierType)
                .and("id")
                .is(id));
        return mongoTemplate.findOne(resourceQuery, carrierType.getCarrierResource(), RESOURCE_COLLECTION);
    }

    @Override
    public void updateResource(Resource resource) {
        Query query = new Query(Criteria
                .where("id")
                .is(resource.getId()));
        Resource objectToUpdate = mongoTemplate.findOne(query, resource.getCarrierType().getCarrierResource(), RESOURCE_COLLECTION);
        resource.setResourceReviews(objectToUpdate.getResourceReviews());

        mongoTemplate.save(resource, RESOURCE_COLLECTION);
    }
}
