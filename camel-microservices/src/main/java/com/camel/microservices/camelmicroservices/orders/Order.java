package com.camel.microservices.camelmicroservices.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    public Order(int i, String string, int j) {

    }

    private int id;
    private String name;
    private double price;

}