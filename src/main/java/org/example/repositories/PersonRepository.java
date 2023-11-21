package org.example.repositories;

import org.example.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer>{
    /**
     * Example: JPA generate Query by Field
     */

    @Query(value = "SELECT p " +
            "FROM Person p "
    )

    List<Person> findAllPersons();

}
