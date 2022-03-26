package ru.sultanyarov.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sultanyarov.library.domain.Reader;

public interface ClientRepository extends MongoRepository<Reader, String>, ClientRepositoryCustom {
    Reader findResourcesInUseById(String clientId); // @Query(fields = "{resourcesInUse:1}") :1 указывает порядок
}
