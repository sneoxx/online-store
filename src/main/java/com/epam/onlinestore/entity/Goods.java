package com.epam.onlinestore.entity;


import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Goods {

  @Id
  @GeneratedValue
  @Column(name = "goods_id")
  UUID goodsId;

  String goodsName;

  String goodsDescription;

  Long goodsPrice;

  Timestamp creationDate;

  Timestamp updateDate;

}