package com.hamilton.proxibanque;

import com.hamilton.proxibanque.dao.EmployeRepository;
import com.hamilton.proxibanque.model.*;
import com.hamilton.proxibanque.dao.ClientRepository;
import com.hamilton.proxibanque.dao.CompteRepository;
import com.hamilton.proxibanque.dao.OperationRepository;
import com.hamilton.proxibanque.services.IBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.function.Consumer;

@SpringBootApplication
public class ProxibanqueApplication implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private IBanqueService iBanqueService;
    @Autowired
    private EmployeRepository employeRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProxibanqueApplication.class, args);
    }




    @Override
    public void run(String... args) throws Exception {

    }
}
