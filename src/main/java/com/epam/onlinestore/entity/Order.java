package com.epam.onlinestore.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "order_id")
  private UUID orderId;

  private String customer;

  private String status;

  private Long amount;

  @ToString.Exclude
  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  private List<Product> products;

  private Timestamp creationDate;

  private Timestamp updateDate;

}
