package com.epam.onlinestore.api.dto;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Data;

@Data
public class GoodsDTO {

  UUID goodsId;

 // @Size(min = 3, max = 50)
  String goodsName;

 // @Size(max = 100)
  String goodsDescription;

 // @Size(max = 50)
  Long goodsPrice;

 Timestamp creationDate;

 Timestamp updateDate;

}