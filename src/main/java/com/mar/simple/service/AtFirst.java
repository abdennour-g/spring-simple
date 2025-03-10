package com.mar.simple.service;

import com.mar.simple.entitie.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Scanner;

@Service
public class AtFirst {

    @Bean
    CommandLineRunner go(ClientService clientService) {
        return a -> {
            File file = ResourceUtils.getFile("classpath:clients.csv");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] lineClient = line.split(",");
                Client client = new Client(null, lineClient[0], lineClient[1]);
                clientService.addClient(new Client(null, lineClient[0], lineClient[1]));
                System.out.println(client);
            }
           System.out.println("done !");
        };
    }

}
