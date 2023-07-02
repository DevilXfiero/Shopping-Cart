package com.project.ShoppingCart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @SequenceGenerator(
            name = "orderSequence",
            sequenceName = "orderSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderSequence"
    )

    private long orderId;
    private String status;
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;




    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(name= "order_product",
            joinColumns = @JoinColumn(
                    name = "orderId",
                    referencedColumnName = "orderId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "productId",
                    referencedColumnName = "productId"
            )


    )
    private List<Product> productList = new ArrayList<>();

    /*@OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id" , referencedColumnName = "cartID")
    private Cart cart;*/
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId" , referencedColumnName = "customerId")
    private Customer customer;




}
