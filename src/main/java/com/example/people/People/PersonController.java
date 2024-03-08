package com.example.people.People;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Person")

public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }
    @GetMapping
    public List<Person> getPerson(){
        return personService.getPerson();
    }
    @PostMapping
    public void registerNewPerson(@RequestBody Person person){
        personService.addNewPerson(person);
    }
    @DeleteMapping(path = "{personId}")
    public void deleteStudents(@PathVariable("personId")Long personId){
        personService.deletePerson(personId);
    }
    @PutMapping(path= "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        personService.updatePerson(personId, name, email);
    }
    @GetMapping(path = "{personId}")
    public Optional<Person> getPerson(@PathVariable Long personId){
        return personService.getPersonById(personId);
    }
}
