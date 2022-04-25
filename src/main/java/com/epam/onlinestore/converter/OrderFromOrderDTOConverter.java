package com.epam.onlinestore.converter;


import com.epam.onlinestore.api.dto.OrderDTO;
import com.epam.onlinestore.entity.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderFromOrderDTOConverter implements Converter<OrderDTO, Order> {

  @Override
  public Order convert(OrderDTO orderDTO) {
    Order order = new Order();
    orderDTO.setOrderId(order.getOrderId());
    orderDTO.setStatus(order.getStatus());
    orderDTO.setCustomer(order.getCustomer());
    orderDTO.setAmount(order.getAmount());

    //не надо давать возможность creationDate и updateDate сетать из API, даты сетаются при создании/изменении записи в БД
    return order;
  }
}
