package com.ust.capstone.user.repository;

import com.ust.capstone.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
