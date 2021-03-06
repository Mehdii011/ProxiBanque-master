package com.hamilton.proxibanque.controller;

import com.hamilton.proxibanque.dao.ClientRepository;
import com.hamilton.proxibanque.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.hamilton.proxibanque.services.ClientServiceImpl;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin("*")
@Slf4j
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id")Long clientId)
            throws ConfigDataResourceNotFoundException {
        Client client=clientRepository.findById(clientId).orElseThrow(()->new EntityNotFoundException("Client n'existe pas pour cet id :" +clientId));
        return ResponseEntity.ok().body(client);
    }
    @PostMapping("/client")
    public ResponseEntity<Client> createclient(@RequestBody Client client) {

        return new ResponseEntity<Client>(clientService.createclient(client), HttpStatus.CREATED);
    }

    @GetMapping("/destroyclient/{id}")
    public ResponseEntity<Long> destroyclient(@PathVariable("id") Long id) {
        log.info("client deleted with success {}", id);
        clientService.destroyclient(id);
        return ResponseEntity.ok().body(id);
    }
    @PutMapping("/editclient")
    public ResponseEntity<Client> editclient( @RequestBody Client client) {
        clientService.editclient(client);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
