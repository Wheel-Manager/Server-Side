package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.RentalActivity;
import com.example.wheelmanager.domain.service.RentalActivityService;
import com.example.wheelmanager.resource.RentalActivityResource;
import com.example.wheelmanager.resource.SaveRentalActivityResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "RentalActivities",description = "RentalActivity API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class RentalActivityController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RentalActivityService rentalActivityService;

    @GetMapping("/rentalActivity")
    public Page<RentalActivityResource> getAllRentalActivities(@ParameterObject Pageable pageable){
        Page<RentalActivity> rentalActivityPage = rentalActivityService.getAllRentalActivities(pageable);
        List<RentalActivityResource> resources = rentalActivityPage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/rentalActivity/{rentalActivityId}")
    public RentalActivityResource getRentalActivityById(@PathVariable(value = "rentalActivityId")Long rentalActivityId){
        return convertToResource(rentalActivityService.getRentalActivitiesById(rentalActivityId));
    }

    @PostMapping("/rentalActivity")
    public RentalActivityResource createRentalActivity(@RequestParam(name = "reservationId") Long reservationId,
                                                   @RequestParam(name = "offerId") Long offerId,
                                                   @Valid @RequestBody SaveRentalActivityResource resource){
        RentalActivity rentalActivity = convertToEntity(resource);
        return convertToResource(rentalActivityService
                .createRentalActivities(reservationId,offerId,rentalActivity));
    }

    @PutMapping("/rentalActivity/{rentalActivityId}")
    public RentalActivityResource updateRentalActivity(@PathVariable(value="rentalActivityId") Long rentalActivityId,
                                                       @Valid @RequestBody SaveRentalActivityResource resource) {
        return convertToResource(rentalActivityService.updateRentalActivities(rentalActivityId,convertToEntity(resource)));
    }

    @DeleteMapping("/rentalActivity/{rentalActivityId}")
    public ResponseEntity<?> deleteRentalActivity(@PathVariable(value="rentalActivityId") Long rentalActivityId){
        return rentalActivityService.deleteRentalActivities(rentalActivityId);
    }

    private RentalActivity convertToEntity(SaveRentalActivityResource resource){
        return mapper.map(resource,RentalActivity.class);
    }

    private RentalActivityResource convertToResource(RentalActivity entity){
        return mapper.map(entity, RentalActivityResource.class);
    }
}
