package org.example.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Person implements Serializable{
    @Id
    @Type(type = "int")
    @Column(name = "id", nullable = false)
    private int id;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
