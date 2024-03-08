package com.example.people.People;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @PathVariable("personId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        personService.updatePerson(studentId, name, email);
    }

}
