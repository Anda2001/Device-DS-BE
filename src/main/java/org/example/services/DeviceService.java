package org.example.services;

import org.example.dtos.DeviceDTO;
import org.example.dtos.DeviceDetailsDTO;
import org.example.dtos.builders.DeviceBuilder;
import org.example.entities.Device;
import org.example.repositories.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceService.class);
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<DeviceDTO> findDevices() {
        List<Device> deviceList = deviceRepository.findAll();
        return deviceList.stream()
                .map(DeviceBuilder::toDeviceDTO)
                .collect(Collectors.toList());
    }

    public DeviceDetailsDTO findDeviceById(Integer id) {
        Optional<Device> deviceOptional = deviceRepository.findById(id);
        if (!deviceOptional.isPresent()) {
            LOGGER.error("Device with id {} was not found in db", id);
            throw new ResourceNotFoundException(Device.class.getSimpleName() + " with id: " + id);
        }
        return DeviceBuilder.toDeviceDetailsDTO(deviceOptional.get());
    }

    public Integer insert(DeviceDetailsDTO deviceDetailsDTO) {
        Device device = DeviceBuilder.toEntity(deviceDetailsDTO);
        device = deviceRepository.save(device);
        LOGGER.debug("Device with id {} was inserted in db", device.getId());
        return device.getId();
    }

    public Integer update(DeviceDTO deviceDTO, Integer id) {
        Optional<Device> deviceOptional = deviceRepository.findById(id);
        if (!deviceOptional.isPresent()) {
            LOGGER.error("Device with id {} was not found in db", id);
            throw new ResourceNotFoundException(Device.class.getSimpleName() + " with id: " + id);
        }
        Device device = deviceOptional.get();
        device.setDescription(deviceDTO.getDescription());
        device.setAddress(deviceDTO.getAddress());
        device.setMaximumHourlyEnergyConsumption(deviceDTO.getMaximumHourlyEnergyConsumption());
        device.setUser(deviceDTO.getUser());
        device = deviceRepository.save(device);
        LOGGER.debug("Device with id {} was updated in db", device.getId());
        return device.getId();
    }

    public void delete(Integer id) {
        Optional<Device> deviceOptional = deviceRepository.findById(id);
        if (!deviceOptional.isPresent()) {
            LOGGER.error("Device with id {} was not found in db", id);
            throw new ResourceNotFoundException(Device.class.getSimpleName() + " with id: " + id);
        }
        deviceRepository.deleteById(id);
        LOGGER.debug("Device with id {} was deleted from db", id);
    }



}
