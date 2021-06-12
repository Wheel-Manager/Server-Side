package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
}
