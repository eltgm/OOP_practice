package ru.sultanyarov.library.service.impl;

import org.springframework.stereotype.Service;
import ru.sultanyarov.library.domain.Reader;
import ru.sultanyarov.library.repository.ClientRepository;
import ru.sultanyarov.library.service.AdminService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final ClientRepository clientRepository;

    public AdminServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Reader createClient(Reader reader) {
        return clientRepository.save(reader);
    }

    @Override
    public boolean blockClient(String clientId) {
        Optional<Reader> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            return false;
        }
        Reader reader = clientOptional.get();
        reader.setBlocked(true);

        clientRepository.save(reader);
        return true;
    }

    @Override
    public boolean unblockClient(String clientId) {
        Optional<Reader> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isEmpty()) {
            return false;
        }
        Reader reader = clientOptional.get();
        reader.setBlocked(false);

        clientRepository.save(reader);
        return true;
    }

    @Override
    public List<Reader> getAllClients() {
        return clientRepository.findAll();
    }
}
