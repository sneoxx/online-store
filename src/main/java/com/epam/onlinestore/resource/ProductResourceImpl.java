package com.epam.onlinestore.resource;

import com.epam.onlinestore.api.dto.ProductDTO;
import com.epam.onlinestore.api.dto.ProductDTO;
import com.epam.onlinestore.api.resource.ProductResource;
import com.epam.onlinestore.entity.Product;
import com.epam.onlinestore.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
@Slf4j
public class ProductResourceImpl implements ProductResource {

  private final ProductService productService;

  private final ConversionService conversionService;

  @Override
  public ProductDTO get(UUID id) {
    Product productResult = productService.getProduct(id);
    ProductDTO productDTOCheck = conversionService.convert(productResult, ProductDTO.class);
    log.info("get() - Получен product: {}", productDTOCheck);
    return productDTOCheck;
  }

  @Override
  public List<ProductDTO> getAll() {
    List<Product> productList = productService.getAllProduct();
    List<ProductDTO> productDTOList = new ArrayList<>();
    for (Product product : productList) {
      productDTOList.add(conversionService.convert(product, ProductDTO.class));
    }
    log.info("getAll() - Получены все product");
    return productDTOList;
  }

  @Override
  public ProductDTO create(ProductDTO productDTO) {
    Product productConvert = conversionService.convert(productDTO, Product.class);
    Product productResult = productService.create(productConvert);
    ProductDTO productDTOCheck = conversionService.convert(productResult, ProductDTO.class);
    log.info("create() - Создан новый Product {}", productDTOCheck);
    return productDTOCheck;
  }
}
