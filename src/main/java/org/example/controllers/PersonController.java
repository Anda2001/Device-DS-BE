package org.example.controllers;

import org.example.dtos.PersonDTO;
import org.example.dtos.PersonDetailsDTO;
import org.example.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getPersons() {
        List<PersonDTO> dtos = personService.findPersons();
        for (PersonDTO dto : dtos) {
            Link personLink = linkTo(methodOn(PersonController.class)
                    .getPerson(dto.getId())).withRel("personDetails");
            dto.add(personLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDetailsDTO> getPerson(@PathVariable("id") int personId) {
        PersonDetailsDTO dto = personService.findPersonById(personId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PersonDetailsDTO> insertPerson(@RequestBody PersonDetailsDTO personDTO) {
        int personId = personService.insert(personDTO);
        return new ResponseEntity<>(personDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Integer> updatePerson(@RequestBody PersonDTO personDTO, @PathVariable("id") int personId) {
        int id = personService.update(personDTO, personId);
        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deletePerson(@PathVariable("id") int personId) {
        personService.delete(personId);
        return new ResponseEntity<>(personId, HttpStatus.OK);
    }
}
