package com.project.ShoppingCart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Customer {
    @Id
    @SequenceGenerator(
            name = "customerSequence",
            sequenceName = "customerSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customerSequence"
    )

    private long customerId;
    @NotBlank(message = "Please add customer name")
    @Length(max=30,min=1)
    private String customerName;

    private String customerEmail;
    private String customerAddress;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn( name = "cart_id", referencedColumnName = "cartId")
    private Cart cart;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="customer")
    public List<Orders> orderList = new ArrayList<>();


}
