package ru.sultanyarov.library.service;

import ru.sultanyarov.library.domain.Reader;

import java.util.List;

public interface AdminService {
    Reader createClient(Reader reader);

    boolean blockClient(String clientId);

    boolean unblockClient(String clientId);

    List<Reader> getAllClients();
}
