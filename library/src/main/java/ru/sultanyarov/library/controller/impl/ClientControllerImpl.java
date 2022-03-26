package ru.sultanyarov.library.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sultanyarov.library.controller.ClientController;
import ru.sultanyarov.library.dto.ClientDto;
import ru.sultanyarov.library.service.ClientsService;

@Controller
public class ClientControllerImpl implements ClientController {
    private final ClientsService clientsService;

    public ClientControllerImpl(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @Override
    @GetMapping("/clients")
    public String moveToClients(Model model) {
        model.addAttribute("readers", clientsService.getAllClients());
        return "clients";
    }

    @Override
    public String editClient(Model model, ClientDto resource) {
        return null;
    }

    @Override
    public String deleteClient(Model model, String id) {
        return null;
    }

    @Override
    public String createClient(Model model) {
        return null;
    }

    @Override
    public String takeResource(Model model, String id) {
        return null;
    }
}
