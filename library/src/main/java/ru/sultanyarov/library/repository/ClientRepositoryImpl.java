package ru.sultanyarov.library.repository;

import lombok.SneakyThrows;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.sultanyarov.library.domain.Author;
import ru.sultanyarov.library.domain.User;
import ru.sultanyarov.library.domain.UserDto;
import ru.sultanyarov.library.mapper.UserMapper;

import static ru.sultanyarov.library.mongock.DatabaseChangelog.USER_COLLECTION;

public class ClientRepositoryImpl implements ClientRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public ClientRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public User findUserByName(String username) {
        var userQuery = new Query(Criteria
                .where("username")
                .is(username));
        UserDto userDto = mongoTemplate.findOne(userQuery, UserDto.class, USER_COLLECTION);

        switch (userDto.get_class()) {
            case "ru.sultanyarov.library.domain.Employer":
                return UserMapper.mapUserDtoToEmployer(userDto);
            case "ru.sultanyarov.library.domain.Reader":
                return UserMapper.mapUserDtoToReader(userDto);
            default:
                return null;
        }
    }
}
