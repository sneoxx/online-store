package com.epam.onlinestore.entity;


import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Product {

  @Id
  @GeneratedValue
  @Column(name = "product_id")
  private UUID productId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "goods_id")
  private Goods goods;

  private String dateOfManufacture;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "order_id")
  private Order order;

  private Timestamp creationDate;

  private Timestamp updateDate;

}