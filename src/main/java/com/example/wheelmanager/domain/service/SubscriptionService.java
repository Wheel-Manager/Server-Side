package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SubscriptionService {
    Page<Subscription> getAllSubscriptions(Pageable pageable);
    Subscription getSubscriptionById(Long subscriptionId);
    Subscription createSubscription(Long userId, Subscription subscription);
    Subscription updateSubscription(Long userId, Long subscriptionId, Subscription messageRequest);
    ResponseEntity<?> deleteSubscription(Long userId, Long subscriptionId);
}
