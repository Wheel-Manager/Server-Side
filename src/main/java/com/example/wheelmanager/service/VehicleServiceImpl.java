package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.*;
import com.example.wheelmanager.domain.repository.*;
import com.example.wheelmanager.domain.service.VehicleService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;


    @Override
    public Page<Vehicle> getAllVehicles(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
    }

    @Override
    public Vehicle createVehicle(Long userId, Long brandId, Long statusId,
                                 Long vehicleTypeId, Vehicle vehicle) {
        return userRepository.findById(userId).map(user-> {
                vehicle.setUser(user);
            return brandRepository.findById(brandId).map(brand -> {
                vehicle.setBrand(brand);
                return statusRepository.findById(statusId).map(status -> {
                    vehicle.setStatus(status);
                    return vehicleTypeRepository.findById(vehicleTypeId).map(vehicleType -> {
                        vehicle.setVehicleType(vehicleType);
                        return vehicleRepository.save(vehicle);
                    }).orElseThrow(() -> new ResourceNotFoundException("VehicleType", "Id", vehicleTypeId));
                }).orElseThrow(() -> new ResourceNotFoundException("Status", "Id", statusId));
            }).orElseThrow(() -> new ResourceNotFoundException("Brand", "Id", brandId));
        }).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicleRequest) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
        return vehicleRepository.save(vehicle.setVehicleName(vehicleRequest.getVehicleName())
                .setImageUrl(vehicleRequest.getImageUrl())
                .setCalification(vehicleRequest.getCalification())
                .setDescription(vehicleRequest.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
        vehicleRepository.delete(vehicle);
        return ResponseEntity.ok().build();
    }
}
