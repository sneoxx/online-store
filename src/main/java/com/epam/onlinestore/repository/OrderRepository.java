package com.epam.onlinestore.repository;

import com.epam.onlinestore.entity.Goods;
import com.epam.onlinestore.entity.Order;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}