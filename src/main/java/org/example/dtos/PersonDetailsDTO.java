package org.example.dtos;


import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PersonDetailsDTO {
    private int id;

    public PersonDetailsDTO() {
    }

    public PersonDetailsDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonDetailsDTO{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDetailsDTO)) return false;
        PersonDetailsDTO that = (PersonDetailsDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
