package com.epam.onlinestore.converter;


import com.epam.onlinestore.api.dto.ProductDTO;
import com.epam.onlinestore.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOFromProductCoverter implements Converter<Product, ProductDTO> {

  @Override
  public ProductDTO convert(Product product) {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setProductId(product.getProductId());
    productDTO.setGoods(product.getGoods().getGoodsId());
    productDTO.setDateOfManufacture(product.getDateOfManufacture());
    //потом убрать
    productDTO.setOrder(product.getOrder().getOrderId());
    productDTO.setCreationDate(product.getCreationDate());
    productDTO.setUpdateDate(product.getUpdateDate());
    return productDTO;
  }
}
