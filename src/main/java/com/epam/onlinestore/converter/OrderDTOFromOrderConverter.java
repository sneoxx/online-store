package com.epam.onlinestore.converter;


import com.epam.onlinestore.api.dto.OrderDTO;
import com.epam.onlinestore.entity.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderDTOFromOrderConverter implements Converter<Order, OrderDTO> {

  @Override
  public OrderDTO convert(Order order) {
    OrderDTO orderDTO = new OrderDTO();
    orderDTO.setOrderId(order.getOrderId());
    orderDTO.setStatus(order.getStatus());
    orderDTO.setCustomer(order.getCustomer());
    orderDTO.setAmount(order.getAmount());
    orderDTO.setProducts(order.getProducts());
    orderDTO.setCreationDate(order.getCreationDate());
    orderDTO.setUpdateDate(order.getUpdateDate());
    return orderDTO;
  }
}
