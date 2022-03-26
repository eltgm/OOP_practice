package ru.sultanyarov.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sultanyarov.library.domain.Resource;

public interface ResourceRepository extends MongoRepository<Resource, String>, ResourceRepositoryCustom {

}
