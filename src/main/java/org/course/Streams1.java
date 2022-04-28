package org.course;

import org.course.model.Bus;
import org.course.model.Vehicle;
import org.course.utils.Printer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.course.utils.DataFactory.getVehicles;
import static org.course.utils.Printer.print;
import static org.course.utils.Printer.printEmptyLine;

/**
 * Streams are wrappers around a data source, allowing us to operate with that data source
 * and making processing convenient and fast.
 * <p>
 * A stream does not store data and, in that sense, is not a data structure.
 * It also never modifies the underlying data source.
 * <p>
 * Java 8 added stream() method to the Collection interface!
 */
public class Streams1 {
    public static void main(String[] args) {

        List<Vehicle> vehicles = getVehicles();


        /*
            Use Stream.map() to get distinct company names from the List<Vehicle>
        */
        List<String> distinctVehicleCompanyNames = vehicles.stream()
                .map(Vehicle::getCompany)
                .distinct()
                .toList();

        distinctVehicleCompanyNames.forEach(Printer::print);
        printEmptyLine();


        /*
            Use Stream.filter() to get vehicles with maxSpeed over 180 from the List<Vehicle>
        */
        List<Vehicle> vehiclesWithMaxSpeedOver180 = vehicles.stream()
                .filter(vehicle -> vehicle.getMaxSpeed() > 180)
                .toList();

        vehiclesWithMaxSpeedOver180.forEach(Printer::print);
        printEmptyLine();


        /*
            Use Stream.limit() to get 2 vehicles with the worst maxSpeed from the List<Vehicle>
        */
        List<Vehicle> limitedVehicles = vehicles.stream()
                .sorted(Comparator.comparingInt(Vehicle::getMaxSpeed))
                .limit(2)
                .toList();

        limitedVehicles.forEach(Printer::print);
        printEmptyLine();


        /*
            Use Stream.sum() to get sum of all maxSpeeds from the List<Vehicle>
        */
        Stream<Integer> streamOfMaxSpeeds = vehicles.stream()
                .map(Vehicle::getMaxSpeed);

        IntStream maxSpeeds = streamOfMaxSpeeds.mapToInt(Integer::intValue);

        // Only when terminal operation happen, stream starts to process the data (Lazy evaluation)
        int sumOfMaxSpeeds = maxSpeeds.sum();

        print(sumOfMaxSpeeds);
        printEmptyLine();
        // Homework: write a very long stream and see how fun is to debug it


        /*
            Use Stream.average() to get average of all maxSpeeds from the List<Vehicle>
        */
        vehicles.stream()
                .mapToInt(Vehicle::getMaxSpeed)
                .average()
                .ifPresentOrElse(Printer::print, () -> print("No vehicle in the stream"));


        /*
            Get all buses from the List<Vehicle> and create new list of super buses 100 km/h faster than previous ones
        */
        List<Bus> superBuses = vehicles.stream()
                .filter(vehicle -> vehicle instanceof Bus)
                .map(bus -> {
                    String superBusName = "Super" + bus.getCompany();
                    int superMaxSpeed = 100 + bus.getMaxSpeed();
                    return new Bus(superBusName, superMaxSpeed);
                })
                .toList();

        superBuses.forEach(Printer::print);
        printEmptyLine();

        /*
            Stream.parallelStream()
        */
        vehicles.parallelStream()
                .forEach(vehicle -> print(Thread.currentThread() + " " + vehicle.toString()));
    }
}
