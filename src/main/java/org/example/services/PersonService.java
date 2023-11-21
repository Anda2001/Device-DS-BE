package org.example.services;
import org.example.dtos.DeviceDTO;
import org.example.dtos.DeviceDetailsDTO;
import org.example.dtos.PersonDTO;
import org.example.dtos.PersonDetailsDTO;
import org.example.dtos.builders.DeviceBuilder;
import org.example.dtos.builders.PersonBuilder;
import org.example.entities.Device;
import org.example.entities.Person;
import org.example.repositories.DeviceRepository;
import org.example.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> findPersons() {
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(PersonBuilder::toPersonDTO)
                .collect(Collectors.toList());
    }

    public PersonDetailsDTO findPersonById(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (!personOptional.isPresent()) {
            LOGGER.error("Person with id {} was not found in db", id);
            throw new ResourceNotFoundException(Person.class.getSimpleName() + " with id: " + id);
        }
        return PersonBuilder.toPersonDetailsDTO(personOptional.get());
    }

    public Integer insert(PersonDetailsDTO personDetailsDTO) {
        Person person = PersonBuilder.toEntity(personDetailsDTO);
        person = personRepository.save(person);
        LOGGER.debug("Person with id {} was inserted in db", person.getId());
        return person.getId();
    }

    public Integer update(PersonDTO personDTO, Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (!personOptional.isPresent()) {
            LOGGER.error("Person with id {} was not found in db", id);
            throw new ResourceNotFoundException(Person.class.getSimpleName() + " with id: " + id);
        }
        Person person = personOptional.get();
        LOGGER.debug("Person with id {} was updated in db", person.getId());
        return person.getId();
    }

    public void delete(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (!personOptional.isPresent()) {
            LOGGER.error("Person with id {} was not found in db", id);
            throw new ResourceNotFoundException(Person.class.getSimpleName() + " with id: " + id);
        }
        personRepository.deleteById(id);
        LOGGER.debug("Person with id {} was deleted from db", id);
    }



}
