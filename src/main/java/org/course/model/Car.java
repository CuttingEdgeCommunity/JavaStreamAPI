package org.course.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Car implements Vehicle {

    private String company;
    private int maxSpeed;

    public String getCompany() {
        return company;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void toot() {
        System.out.println("Toot");
    }
}
