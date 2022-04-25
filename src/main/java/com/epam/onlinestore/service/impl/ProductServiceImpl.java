package com.epam.onlinestore.service.impl;

import com.epam.onlinestore.entity.Product;
import com.epam.onlinestore.repository.ProductRepository;
import com.epam.onlinestore.repository.ProductRepository;
import com.epam.onlinestore.service.ProductService;
import com.epam.onlinestore.service.ProductService;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Product getProduct(UUID id) {
    Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
    log.debug("getProduct() Объект Product успешно получен из БД: {}", product);
    return product;
  }

  @Override
  public List<Product> getAllProduct() {
    List<Product> productList = productRepository.findAll();
    log.debug("getAllProduct() Объекты Product успешно получены из БД: {}", productList);
    return productList;
  }

  @Override
  public Product create(Product product) {
    Product productCheck;
    if (product.getProductId() != null && productRepository.existsById(product.getProductId())) {
      Timestamp creationDate = productRepository.findById(product.getProductId()).orElseThrow(RuntimeException::new).getCreationDate();
      product.setCreationDate(creationDate);
      product.setUpdateDate(new Timestamp(System.currentTimeMillis()));
      productCheck = productRepository.save(product);
      log.debug("create() Объект Product успешно обновлен в БД: {} ", productCheck);

    } else {
      product.setCreationDate(new Timestamp(System.currentTimeMillis()));
      productCheck = productRepository.save(product);
      log.debug("create() Объект Product успешно записан в БД: {} ", productCheck);
    }
    return productCheck;
  }

}
