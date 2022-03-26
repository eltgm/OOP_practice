package ru.sultanyarov.library.repository;

import ru.sultanyarov.library.domain.User;

public interface ClientRepositoryCustom {

    User findUserByName(String username);
}
