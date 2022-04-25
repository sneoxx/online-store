package com.epam.onlinestore.api.dto;

import java.sql.Timestamp;
import java.util.UUID;
import lombok.Data;

@Data
public class ProductDTO {

  private UUID productId;

  private UUID goods;

  private String dateOfManufacture;

  private UUID order; //потом убрать

  Timestamp creationDate;

  Timestamp updateDate;

}