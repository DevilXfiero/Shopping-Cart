package com.project.ShoppingCart.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart  {


    @Id
    @SequenceGenerator(
            name = "cartSequence",
            sequenceName = "cartSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cartSequence"
    )

    private long cartId;




   @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(name= "cart_product",
            joinColumns = @JoinColumn (
                    name = "cartId",
                    referencedColumnName = "cartId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "productId",
                    referencedColumnName = "productId"
            )


    )
    private List<Product> productList = new ArrayList<>();

    public Cart(long cartId) {
        this.cartId = cartId;
    }
/*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id" , referencedColumnName = "cartID")
    private List<Product> productList;*/

}
