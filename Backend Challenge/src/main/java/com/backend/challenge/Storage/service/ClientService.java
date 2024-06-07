package com.backend.challenge.Storage.service;

import com.backend.challenge.Storage.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> fetchClients();
    void saveClient(Client client);
    Client getClientById(Long id);
    void deleteClient(Long id);
}
