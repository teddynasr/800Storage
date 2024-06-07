package com.backend.challenge.Storage.service.impl;

import com.backend.challenge.Storage.entity.Client;
import com.backend.challenge.Storage.repository.ClientRepository;
import com.backend.challenge.Storage.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    @Lazy
    private ClientRepository clientRepository;

    @Override
    public List<Client> fetchClients() {
        return clientRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).isPresent()?clientRepository.findById(id).get():null;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
