package com.ust.capstone.user.service;

import com.ust.capstone.user.dto.CreateUserRequest;
import com.ust.capstone.user.dto.OrderStatusEvent;
import com.ust.capstone.user.model.OrderNotification;
import com.ust.capstone.user.model.User;
import com.ust.capstone.user.repository.OrderNotificationRepository;
import com.ust.capstone.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final OrderNotificationRepository notificationRepository;

    public UserService(UserRepository userRepository, OrderNotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    public User createUser(CreateUserRequest request) {
        return userRepository.save(new User(request.name(), request.email()));
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void saveNotification(OrderStatusEvent event) {
        notificationRepository.save(new OrderNotification(
                event.userId(),
                event.orderId(),
                event.status(),
                event.message()
        ));
    }

    public List<OrderNotification> getNotifications(Long userId) {
        return notificationRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }
}
