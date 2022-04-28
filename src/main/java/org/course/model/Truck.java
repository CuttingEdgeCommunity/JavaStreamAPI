package org.course.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Truck implements Vehicle {

    private String company;
    private int maxSpeed;

    @Override
    public String getCompany() {
        return company;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void toot() {
        System.out.println("Toooooot");
    }
}
