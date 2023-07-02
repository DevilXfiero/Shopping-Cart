package com.project.ShoppingCart.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
   @Id
   @SequenceGenerator(
           name = "productSequence",
           sequenceName = "productSequence",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "productSequence"
   )
   private long productId;
   private String productName;
   private long sellingPrice;
}
