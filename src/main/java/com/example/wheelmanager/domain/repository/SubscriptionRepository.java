package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByIdAndUserId(Long id, Long userId);
}
