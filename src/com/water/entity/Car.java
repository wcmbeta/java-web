package com.water.entity;

import org.springframework.stereotype.Component;

/**
 * Created by Water on 17/5/17.
 * Email:water471871679@gmail.com
 */
@Component("car")
public class Car {
    private String name;
    private float speed;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }
}
