package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.UserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserAddressService {
    Page<UserAddress> getAllUserAddresses(Pageable pageable);
    UserAddress getUserAddressesById(Long userAddressId);
    UserAddress createUserAddresses(Long userId,Long addressId,UserAddress userAddress);
    UserAddress updateUserAddresses(Long userId,Long addressId,Long userAddressId,UserAddress messageRequest);
    ResponseEntity<?> deleteUserAddresses(Long userId,Long addressId,Long userAddressId);
}
