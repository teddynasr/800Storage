package com.backend.challenge.Storage.repository;

import com.backend.challenge.Storage.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}
