package org.example.dtos.builders;

import org.example.dtos.DeviceDTO;
import org.example.dtos.DeviceDetailsDTO;
import org.example.dtos.PersonDTO;
import org.example.dtos.PersonDetailsDTO;
import org.example.entities.Device;
import org.example.entities.Person;

public class PersonBuilder {
    public static PersonDTO toPersonDTO(Person person) {
        return new PersonDTO(person.getId());
    }

    public static PersonDetailsDTO toPersonDetailsDTO(Person person) {
        return new PersonDetailsDTO(person.getId());
    }

    public static Person toEntity(PersonDetailsDTO personDetailsDTO) {
        return new Person(personDetailsDTO.getId());
    }
}
