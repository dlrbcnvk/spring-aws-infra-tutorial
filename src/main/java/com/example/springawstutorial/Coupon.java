package com.example.springawstutorial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    public Coupon(){ }

    public Coupon(int quantity) {
        this.quantity = quantity;
    }

    public int increment() {
        quantity++;
        return quantity;
    }

    public int decrement() {
        quantity--;
        return quantity;
    }
}
