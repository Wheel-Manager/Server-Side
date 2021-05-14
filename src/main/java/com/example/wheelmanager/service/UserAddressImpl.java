package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.UserAddress;
import com.example.wheelmanager.domain.repository.AddressRepository;
import com.example.wheelmanager.domain.repository.UserAddressRepository;
import com.example.wheelmanager.domain.repository.UserRepository;
import com.example.wheelmanager.domain.service.UserAddressService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserAddressImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Page<UserAddress> getAllUserAddressesByUserId(Long userId, Pageable pageable) {
        return userAddressRepository.getAllUserAddressesByUserId(userId,pageable);
    }

    @Override
    public Page<UserAddress> getAllUserAddressesByAddressId(Long addressId, Pageable pageable) {
        return userAddressRepository.getAllUserAddressesByAddressId(addressId,pageable);
    }

    @Override
    public UserAddress getUserAddressesByIdByUserIdAndAddressId(Long userId, Long addressId, Long userAddressId) {
        return userAddressRepository.findByIdAndUserIdAndAddressId(userAddressId,userId,addressId)
                .orElseThrow(()->new ResourceNotFoundException(
                        "User Address not found with Id"+userAddressId
                                +"and UserId"+userId+"and AddressId"+addressId));
    }

    @Override
    public UserAddress createUserAddresses(Long userId, Long addressId, UserAddress userAddress) {
        return userRepository.findById(userId).map(user->{
            userAddress.setUser(user);
            return addressRepository.findById(addressId).map(address -> {
                userAddress.setAddress(address);
                return userAddressRepository.save(userAddress);
            }).orElseThrow(()->new ResourceNotFoundException("Address","Id", addressId));
        }).orElseThrow(()->new ResourceNotFoundException("User","Id", userId));
    }

    @Override
    public UserAddress updateUserAddresses(Long userId, Long addressId, Long userAddressId, UserAddress userAddressRequest) {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User","Id",userId);
        if(!addressRepository.existsById(addressId))
            throw new ResourceNotFoundException("Address","Id",addressId);
        return userAddressRepository.findById(userAddressId).map(userAddress-> {
            userAddress.setAddress(userAddressRequest.getAddress())
                    .setUser(userAddressRequest.getUser())
                    .setSelected(userAddressRequest.isSelected());
            return userAddressRepository.save(userAddress);
        }).orElseThrow(()->new ResourceNotFoundException("UserAddress","Id",userAddressId));
    }

    @Override
    public ResponseEntity<?> deleteUserAddresses(Long userId, Long addressId, Long userAddressId) {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User","Id",userId);
        if(!addressRepository.existsById(addressId))
            throw new ResourceNotFoundException("Address","Id",addressId);
        return userAddressRepository.findById(userAddressId).map(userAddress-> {
            userAddressRepository.delete(userAddress);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("UserAddress","Id",userAddressId));
    }
}
