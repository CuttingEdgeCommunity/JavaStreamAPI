package org.course.utils;

import org.course.model.Bus;
import org.course.model.Car;
import org.course.model.Truck;
import org.course.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataFactory {

    public static List<Vehicle> getVehicles() {
        return List.of(
                new Car("Volvo", 180),
                new Truck("Volvo", 120),
                new Car("BMW", 250),
                new Bus("Solaris", 120),
                new Bus("Mercedes", 130),
                new Bus("Volvo", 110),
                new Truck("Man", 120),
                new Car("Volkswagen", 200),
                new Car("Toyota", 190),
                new Car("Mercedes", 240)
        );
    }

    public static List<Vehicle> emptyList() {
        return new ArrayList<>();
    }
    public static Optional<List<Vehicle>> optionalListNotEmpty() {
        return Optional.of(List.of(
                new Car("Volvo", 150),
                new Truck("Man", 120)));
    }

    public static Optional<List<Vehicle>> optionalListEmpty() {
        return Optional.empty();
    }
}
