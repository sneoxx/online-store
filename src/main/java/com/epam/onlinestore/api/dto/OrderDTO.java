package com.epam.onlinestore.api.dto;



import com.epam.onlinestore.entity.Product;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import lombok.Data;


@Data
public class OrderDTO {

  private UUID orderId;

  private String customer;

  private String status;

  private Long amount;

  private List<Product> products;

  Timestamp creationDate;

  Timestamp updateDate;

}
