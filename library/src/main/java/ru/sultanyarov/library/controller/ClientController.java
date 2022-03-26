package ru.sultanyarov.library.controller;

import org.springframework.ui.Model;
import ru.sultanyarov.library.dto.ClientDto;

public interface ClientController {
    String moveToClients(Model model);

    String editClient(Model model, ClientDto resource);

    String deleteClient(Model model, String id);

    String createClient(Model model);

    String takeResource(Model model, String id);
}
