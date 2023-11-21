package org.example.dtos.builders;

import org.example.dtos.DeviceDTO;
import org.example.dtos.DeviceDetailsDTO;
import org.example.entities.Device;

public class DeviceBuilder {
    public static DeviceDTO toDeviceDTO(Device device) {
        return new DeviceDTO(device.getId(), device.getDescription(), device.getAddress(), device.getMaximumHourlyEnergyConsumption(), device.getUser());
    }

    public static DeviceDetailsDTO toDeviceDetailsDTO(Device device) {
        return new DeviceDetailsDTO(device.getId(), device.getDescription(), device.getAddress(), device.getMaximumHourlyEnergyConsumption(), device.getUser());
    }

    public static Device toEntity(DeviceDetailsDTO deviceDetailsDTO) {
        return new Device(deviceDetailsDTO.getDescription(),
                deviceDetailsDTO.getAddress(),
                deviceDetailsDTO.getMaximumHourlyEnergyConsumption(),
                deviceDetailsDTO.getUser());
    }
}
