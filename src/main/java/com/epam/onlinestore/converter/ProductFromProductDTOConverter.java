package com.epam.onlinestore.converter;


import com.epam.onlinestore.api.dto.ProductDTO;
import com.epam.onlinestore.entity.Goods;
import com.epam.onlinestore.entity.Order;
import com.epam.onlinestore.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductFromProductDTOConverter implements Converter<ProductDTO, Product> {

  @Override
  public Product convert(ProductDTO productDTO) {
    Product product = new Product();
    product.setProductId(productDTO.getProductId());
    Goods goods = new Goods();
    goods.setGoodsId(productDTO.getProductId());
    product.setGoods(goods);
    product.setDateOfManufacture(productDTO.getDateOfManufacture());
    //потом убрать
    Order order = new Order();
    order.setOrderId(productDTO.getOrder());
    product.setOrder(order);
    //не надо давать возможность creationDate и updateDate сетать из API, даты сетаются при создании/изменении записи в БД
    return product;
  }
}
