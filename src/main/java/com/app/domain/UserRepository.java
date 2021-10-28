package com.app.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(value = "User.todos")
    User findByUserId(Long userId);
}
