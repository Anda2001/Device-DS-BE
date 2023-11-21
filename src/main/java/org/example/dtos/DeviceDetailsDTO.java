package org.example.dtos;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class DeviceDetailsDTO {
    private int id;

    @NotNull
    private String description;

    @NotNull
    private String address;

    @NotNull
    private int maximumHourlyEnergyConsumption;

    @NotNull
    private int user;

    public DeviceDetailsDTO() {
    }

    public DeviceDetailsDTO(String description, String address, int maximumHourlyEnergyConsumption, int user) {
        this.description = description;
        this.address = address;
        this.maximumHourlyEnergyConsumption = maximumHourlyEnergyConsumption;
        this.user = user;
    }

    public DeviceDetailsDTO(int id, String description, String address, int maximumHourlyEnergyConsumption, int user) {
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
        this.id= id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description= description;
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
        this.user= user;
    }

    @Override
    public String toString() {
        return "DeviceDetailsDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", maximum_hourly_energy_consumption='" + maximumHourlyEnergyConsumption + '\'' +
                ", user_id='" + user + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceDetailsDTO)) return false;
        DeviceDetailsDTO that = (DeviceDetailsDTO) o;
        return id == that.id && description.equals(that.description) && address.equals(that.address) && maximumHourlyEnergyConsumption == that.maximumHourlyEnergyConsumption && user==that.user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, address, maximumHourlyEnergyConsumption, user);
    }

}
