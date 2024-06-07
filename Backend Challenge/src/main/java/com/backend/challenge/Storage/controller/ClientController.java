package com.backend.challenge.Storage.controller;

import com.backend.challenge.Storage.entity.Client;
import com.backend.challenge.Storage.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {
    @Autowired
    @Lazy
    ClientService clientService;

    @GetMapping("/clients")
    public String showClients(Model model){
        model.addAttribute("clients", clientService.fetchClients());
        return "clients";
    }

    @GetMapping("/clients/new")
    public String createClient(Model model){
        model.addAttribute("client", new Client());
        return "createClient";
    }

    @PostMapping("/clients")
    public String saveClient(@ModelAttribute(name="client")Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/edit/{id}")
    public String updateClient(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "updateClient";
    }

    @PostMapping("/clients/{id}")
    public String saveUpdatedClient(@ModelAttribute("client")Client client){
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}
