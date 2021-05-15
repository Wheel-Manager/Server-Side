package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Subscription;
import com.example.wheelmanager.domain.service.SubscriptionService;
import com.example.wheelmanager.resource.SaveSubscriptionResource;
import com.example.wheelmanager.resource.SubscriptionResource;
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

@Tag(name = "Subscription",description = "Subscription API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/subscriptions")
    public Page<SubscriptionResource> getAllSubscriptions(Pageable pageable){
        Page<Subscription> subscriptionPage = subscriptionService.getAllSubscriptions(pageable);
        List<SubscriptionResource> resources = subscriptionPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/subscriptions/{subscriptionId}")
    public SubscriptionResource getSubscriptionById(@PathVariable(value = "subscriptionId")Long subscriptionId){
        return convertToResource(subscriptionService.getSubscriptionById(subscriptionId));
    }

    @PostMapping("/users/{userId}/subscriptions")
    public SubscriptionResource createSubscription(@PathVariable(value = "userId") Long userId,
                                                   @Valid @RequestBody SaveSubscriptionResource resource){
        Subscription subscription = convertToEntity(resource);
        return  convertToResource(subscriptionService.createSubscription(userId, subscription));
    }

    @PutMapping("/users/{userId}/subscriptions/{subscriptionId}")
    public SubscriptionResource updateSubscription(@PathVariable (value = "userId") Long userId,
                                                   @PathVariable (value = "subscriptionId") Long subscriptionId, @Valid @RequestBody SaveSubscriptionResource resource){
        Subscription subscription = convertToEntity(resource);
        return  convertToResource(subscriptionService.updateSubscription(userId, subscriptionId,subscription));
    }

    @DeleteMapping("/users/{userId}/subscriptions/{subscriptionId}")
    public ResponseEntity<?> deleteSubscription( @PathVariable (value = "userId") Long userId,
                                                 @PathVariable Long subscriptionId){
        return subscriptionService.deleteSubscription(userId, subscriptionId);
    }

    private Subscription convertToEntity(SaveSubscriptionResource resource){
        return mapper.map(resource,Subscription.class);
    }

    private SubscriptionResource convertToResource(Subscription entity){
        return mapper.map(entity, SubscriptionResource.class);
    }

}
