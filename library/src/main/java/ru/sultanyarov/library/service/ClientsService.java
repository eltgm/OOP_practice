package ru.sultanyarov.library.service;

import ru.sultanyarov.library.domain.Reader;
import ru.sultanyarov.library.domain.Resource;

import java.util.List;

public interface ClientsService {
    Resource takeResource(String resourceId);

    boolean returnResource(Resource resource);

    boolean leaveFeedback(String resourceId, String comment, int rate);

    boolean deleteAccount();

    List<Reader> getAllClients();
}
