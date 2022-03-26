package ru.sultanyarov.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sultanyarov.library.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Author findByFio(String fio);
}
