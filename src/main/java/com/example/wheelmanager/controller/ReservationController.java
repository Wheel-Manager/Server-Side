package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Reservation;
import com.example.wheelmanager.domain.model.UserAddress;
import com.example.wheelmanager.domain.service.ReservationService;
import com.example.wheelmanager.resource.ReservationResource;
import com.example.wheelmanager.resource.SaveReservationResource;
import com.example.wheelmanager.resource.UserAddressResource;
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

    @GetMapping("/reservations")
    public Page<ReservationResource> getAllReservations(Pageable pageable){
        Page<Reservation> reservationPage = reservationService.getAllReservations(pageable);
        List<ReservationResource> resources=reservationPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/reservations/{reservationId}")
    public ReservationResource getReservationById(@PathVariable(value = "reservationId")Long reservationId){
        return convertToResource(reservationService.getReservationsById(reservationId));
    }

    @PostMapping("/reservations")
    public ReservationResource createReservation(@RequestParam(name = "userId") Long userId, @RequestParam(name = "vehicleId") Long vehicleId, @Valid @RequestBody SaveReservationResource resource){
        return convertToResource(reservationService.createReservation(userId,vehicleId,convertToEntity(resource)));
    }

    @PutMapping("/reservations/{reservationId}")
    public ReservationResource updateReservation(@PathVariable(value="reservationId") Long reservationId,@Valid @RequestBody SaveReservationResource resource) {
        return convertToResource(reservationService.updateReservation(reservationId,convertToEntity(resource)));
    }

    @DeleteMapping("/reservations/{reservationId}")
    public ResponseEntity<?> deleteReservation(@PathVariable(value="reservationId") Long reservationId){
        return reservationService.deleteReservation(reservationId);
    }

    private Reservation convertToEntity(SaveReservationResource resource){
        return mapper.map(resource,Reservation.class);
    }

    private ReservationResource convertToResource(Reservation entity){
        return mapper.map(entity, ReservationResource.class);
    }
}