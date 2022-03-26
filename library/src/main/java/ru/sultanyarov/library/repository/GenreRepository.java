package ru.sultanyarov.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sultanyarov.library.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
    Genre findByName(String name);
}
