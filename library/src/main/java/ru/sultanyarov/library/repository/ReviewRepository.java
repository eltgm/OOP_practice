package ru.sultanyarov.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sultanyarov.library.domain.Review;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findAllByResource_Id(String resourceId);
}
