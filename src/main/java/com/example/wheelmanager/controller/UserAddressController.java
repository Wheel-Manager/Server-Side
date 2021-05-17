package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.UserAddress;
import com.example.wheelmanager.domain.service.UserAddressService;
import com.example.wheelmanager.resource.SaveUserAddressResource;
import com.example.wheelmanager.resource.UserAddressResource;
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

@Tag(name = "UserAddresses",description = "UserAddress API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserAddressController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserAddressService userAddressService;

    @GetMapping("/userAddress")
    public Page<UserAddressResource> getAllUserAddresses(@ParameterObject Pageable pageable){
        Page<UserAddress> userAddressResourcePage = userAddressService.getAllUserAddresses(pageable);
        List<UserAddressResource> resources=userAddressResourcePage.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/userAddress/{userAddressId}")
    public UserAddressResource getUserAddressById(@PathVariable(value = "userAddressId")Long userAddressId){
        return convertToResource(userAddressService.getUserAddressesById(userAddressId));
    }

    @PostMapping("/userAddress")
    public UserAddressResource createUserAddresses(@RequestParam(name = "userId") Long userId,
                                                   @RequestParam(name = "addressId") Long addressId,
                                                   @Valid @RequestBody SaveUserAddressResource resource){
        UserAddress userAddress=convertToEntity(resource);
        return convertToResource(userAddressService.createUserAddresses(userId,addressId,userAddress));
    }

    @PutMapping("/userAddress/{userAddressId}")
    public UserAddressResource updateUserAddresses(@PathVariable(value="userAddressId") Long userAddressId,@Valid @RequestBody SaveUserAddressResource resource) {
        return convertToResource(userAddressService.updateUserAddresses(userAddressId,convertToEntity(resource)));
    }

    @DeleteMapping("/userAddress/{userAddressId}")
    public ResponseEntity<?> deleteUserAddresses(@PathVariable(value="userAddressId") Long userAddressId){
        return userAddressService.deleteUserAddresses(userAddressId);
    }

    private UserAddress convertToEntity(SaveUserAddressResource resource){
        return mapper.map(resource,UserAddress.class);
    }

    private UserAddressResource convertToResource(UserAddress entity){
        return mapper.map(entity, UserAddressResource.class);
    }
}
