package org.example.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class DeviceDTO extends RepresentationModel<DeviceDTO> {

    private int id;
    private String description;
    private String address;
    private int maximumHourlyEnergyConsumption;
    private int user;

    public DeviceDTO() {
    }

    public DeviceDTO(int id, String description, String address, int maximumHourlyEnergyConsumption, int user) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.maximumHourlyEnergyConsumption = maximumHourlyEnergyConsumption;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public int getMaximumHourlyEnergyConsumption() {
        return maximumHourlyEnergyConsumption;
    }

    public int getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", maximumHourlyEnergyConsumption=" + maximumHourlyEnergyConsumption +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceDTO)) return false;
        DeviceDTO deviceDTO = (DeviceDTO) o;
        return id == deviceDTO.id && description.equals(deviceDTO.description) && address.equals(deviceDTO.address) && maximumHourlyEnergyConsumption == deviceDTO.maximumHourlyEnergyConsumption && user == deviceDTO.user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, address, maximumHourlyEnergyConsumption, user);
    }
}
