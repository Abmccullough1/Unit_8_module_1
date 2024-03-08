package com.example.people.People;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> personOptional = personRepository.findPersonByEmail(person.getEmail());
        if (personOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        personRepository.save(person);
    }
    public void deletePerson(Long personId){
        boolean exists =  personRepository.existsById(personId);
        if (!exists){
            throw new IllegalStateException("student with id "+personId+" does not exist");
        }
        personRepository.deleteById(personId);

    }
    @Transactional
    public void updatePerson(Long personId,
                              String name,
                              String email){
        Person person = personRepository.findById(personId).orElseThrow(() -> new IllegalStateException(
                "Person with Id " + personId + " Does not Exist."
        ));

        if (name != null && name.length() > 0 && !Objects.equals(person.getName(), name)){
            person.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(person.getEmail(), email)){
            Optional<Person> personOptional = personRepository.findPersonByEmail(email);
            if (personOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            person.setEmail(email);
        }

    }
}
