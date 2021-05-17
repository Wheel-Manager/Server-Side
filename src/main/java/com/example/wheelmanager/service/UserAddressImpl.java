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
    public Page<UserAddress> getAllUserAddresses(Pageable pageable) {
        return userAddressRepository.findAll(pageable);
    }

    @Override
    public UserAddress getUserAddressesById(Long userAddressId){
        return userAddressRepository.findById(userAddressId).orElseThrow(() -> new ResourceNotFoundException("UserAddress", "Id",userAddressId));
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
    public UserAddress updateUserAddresses(Long userAddressId, UserAddress userAddressRequest) {
       UserAddress userAddress = userAddressRepository.findById(userAddressId)
               .orElseThrow(() -> new ResourceNotFoundException("UserAddress", "Id",userAddressId));
       return  userAddressRepository.save(userAddress.setSelected(userAddressRequest.isSelected()));
    }

    @Override
    public ResponseEntity<?> deleteUserAddresses(Long userAddressId) {
        UserAddress userAddress = userAddressRepository.findById(userAddressId)
                .orElseThrow(() -> new ResourceNotFoundException("UserAddress", "Id",userAddressId));
        userAddressRepository.delete(userAddress);
        return ResponseEntity.ok().build();
    }
}
