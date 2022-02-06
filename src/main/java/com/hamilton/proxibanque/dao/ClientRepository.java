package com.hamilton.proxibanque.dao;

import com.hamilton.proxibanque.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client,Long> {
    public List<Client> findAll();
}
