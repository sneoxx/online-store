package com.epam.onlinestore.service;

import com.epam.onlinestore.entity.Goods;
import com.epam.onlinestore.entity.Product;
import java.util.List;
import java.util.UUID;

public interface ProductService {

  /**
   * Получение Product из БД
   *
   * @param id - id Product, которое необходимо получить
   * @return - product полученный из базы или новый product в случае отсутствия такового id в БД
   */
  Product getProduct(UUID id);

  /**
   * Получение всех Product из БД
   *
   * @return - коллекция list goods
   */
  List<Product> getAllProduct();

  /**
   * Создание и запись в БД экземпляра Product
   *
   * @param product- Экземпляр Goods
   * @return - Product записанный в базу
   */
  Product create(Product product);

}