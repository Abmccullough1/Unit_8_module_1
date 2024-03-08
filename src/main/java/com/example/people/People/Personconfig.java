package com.example.people.People;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Personconfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            Person William = new Person(
                    "William",
                    "william@google.com",
                    LocalDate.of(2004, Month.SEPTEMBER,11)

            );
            Person Alex =new Person(
                    "Alex",
                    "Alexm@google.com",
                    LocalDate.of(2000, Month.JANUARY,1)



            );
            repository.saveAll(
                    List.of(William, Alex)
            );

        };
    }
}
