package org.example.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Device implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "int")
    @Column(name = "id")
    private int id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "maximum_hourly_energy_consumption", nullable = false)
    private int maximumHourlyEnergyConsumption;

    @Column(name = "user_id", nullable = false)
    private int user;

    public Device() {
    }

    public Device(String description, String address, int maximumHourlyEnergyConsumption, int user) {
        this.description = description;
        this.address = address;
        this.maximumHourlyEnergyConsumption = maximumHourlyEnergyConsumption;
        this.user = user;
    }

    public Device(int id, String description, String address, int maximumHourlyEnergyConsumption, int user) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.maximumHourlyEnergyConsumption = maximumHourlyEnergyConsumption;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address= address;
    }

    public int getMaximumHourlyEnergyConsumption() {
        return maximumHourlyEnergyConsumption;
    }

    public void setMaximumHourlyEnergyConsumption(int maximumHourlyEnergyConsumption) {
        this.maximumHourlyEnergyConsumption = maximumHourlyEnergyConsumption;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

}
