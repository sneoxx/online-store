package com.epam.onlinestore.repository;

import com.epam.onlinestore.entity.Goods;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GoodsRepository extends JpaRepository<Goods, UUID> {

}