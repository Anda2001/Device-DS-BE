package org.example.controllers;

import org.example.dtos.DeviceDTO;
import org.example.dtos.DeviceDetailsDTO;
import org.example.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/device")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping()
    public ResponseEntity<List<DeviceDTO>> getDevices() {
        List<DeviceDTO> dtos = deviceService.findDevices();
        for (DeviceDTO dto : dtos) {
            Link deviceLink = linkTo(methodOn(DeviceController.class)
                    .getDevice(dto.getId())).withRel("deviceDetails");
            dto.add(deviceLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DeviceDetailsDTO> getDevice(@PathVariable("id") int deviceId) {
        DeviceDetailsDTO dto = deviceService.findDeviceById(deviceId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DeviceDetailsDTO> insertDevice(@RequestBody DeviceDetailsDTO deviceDTO) {
        int deviceId = deviceService.insert(deviceDTO);
        return new ResponseEntity<>(deviceDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Integer> updateDevice(@RequestBody DeviceDTO deviceDTO, @PathVariable("id") int deviceId) {
        int id = deviceService.update(deviceDTO, deviceId);
        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deleteDevice(@PathVariable("id") int deviceId) {
        deviceService.delete(deviceId);
        return new ResponseEntity<>(deviceId,HttpStatus.OK);
    }

}
