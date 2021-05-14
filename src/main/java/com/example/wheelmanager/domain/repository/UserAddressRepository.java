package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.UserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAddressRepository extends JpaRepository<UserAddress,Long> {
    Page<UserAddress> getAllUserAddressesByUserId(Long userId, Pageable pageable);
    Page<UserAddress> getAllUserAddressesByAddressId(Long addressId, Pageable pageable);
    Optional<UserAddress> findByIdAndUserIdAndAddressId(Long id,Long userId,Long addressId);
    Optional<UserAddress> findByUserIdAndAddressId(Long userId,Long addressId);
}
