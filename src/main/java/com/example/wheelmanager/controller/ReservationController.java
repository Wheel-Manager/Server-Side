package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Reservation;
import com.example.wheelmanager.domain.service.ReservationService;
import com.example.wheelmanager.resource.ReservationResource;
import com.example.wheelmanager.resource.SaveReservationResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Reservation",description = "Reservation API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations/{user_id}")
    public Page<ReservationResource> getAllReservationByUserId(@PathVariable(name = "userId") Long userId, Pageable pageable){
        Page<Reservation> reservationPage=reservationService.getAllReservationsByUserId(userId,pageable);
        List<ReservationResource> resources=reservationPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/reservations/{vehicleId}")
    public Page<ReservationResource> getAllReservationsByVehicleId(@PathVariable(name = "vehicleId") Long vehicleId, Pageable pageable){
        Page<Reservation> reservationPage=reservationService.getAllReservationsByVehicleId(vehicleId,pageable);
        List<ReservationResource> resources=reservationPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @PostMapping("/reservations")
    public ReservationResource createReservation(@RequestParam(name = "userId") Long userId, @RequestParam(name = "vehicleId") Long vehicleId, @Valid @RequestBody SaveReservationResource resource){
        return convertToResource(reservationService.createReservation(userId,vehicleId,convertToEntity(resource)));
    }

    @PutMapping("/reservations/{reservationId}")
    public ReservationResource updateReservation(@RequestParam(name = "userId") Long userId, @RequestParam(name = "vehicleId") Long vehicleId, @PathVariable(value="reservationId") Long reservationId,@Valid @RequestBody SaveReservationResource resource) {
        return convertToResource(reservationService.updateReservation(userId,vehicleId,reservationId,convertToEntity(resource)));
    }

    @DeleteMapping("/reservations/{reservationId}")
    public ResponseEntity<?> deleteReservation(@RequestParam(name = "userId") Long userId, @RequestParam(name = "vehicleId") Long vehicleId, @PathVariable(value="reservationId") Long reservationId){
        return reservationService.deleteReservation(userId,vehicleId,reservationId);
    }

    private Reservation convertToEntity(SaveReservationResource resource){
        return mapper.map(resource,Reservation.class);
    }

    private ReservationResource convertToResource(Reservation entity){
        return mapper.map(entity, ReservationResource.class);
    }
}