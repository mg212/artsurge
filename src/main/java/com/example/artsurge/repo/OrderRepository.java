package com.example.artsurge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// OrderRepository interface
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
