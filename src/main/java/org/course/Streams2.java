package org.course;

import org.course.model.Vehicle;
import org.course.utils.DataFactory;

import java.util.*;
import java.util.stream.Collectors;

import static org.course.utils.DataFactory.getVehicles;
import static org.course.utils.Printer.print;

public class Streams2 {
    public static void main(String[] args) {

        /*
          forEach
          for each vehicle perform toot()
         */
        getVehicles().forEach(Vehicle::toot);

        /*
          groupingBy
          1. Group vehicles by company
          2. Group vehicles by company and use the set
          3. Group vehicles by company and speed
          use map -> flatMap -> napisz metode w utls która zwraca listę list
         */
        Map<String, List<Vehicle>> groupedByCompany = getVehicles()
                .stream()
                .collect(Collectors.groupingBy(Vehicle::getCompany));

        Map<String, Set<Vehicle>> groupedByCompanySet = getVehicles()
                .stream()
                .collect(Collectors.groupingBy(Vehicle::getCompany, Collectors.toSet()));

        Map<String, Map<Integer, List<Vehicle>>> groupedByCompanyAndSpeed = getVehicles()
                .stream()
                .collect(Collectors.groupingBy(Vehicle::getCompany, Collectors.groupingBy(Vehicle::getMaxSpeed)));

         /*
          flat map
          1. flatMap()
          2. groupingBy()
         */
        List<List<Vehicle>> nestedVehicleList = new ArrayList<>();
        groupedByCompany.forEach((company, vehicles) -> nestedVehicleList.add(vehicles));
        List<Vehicle> flatMapVehicles = nestedVehicleList
                .stream()
                .flatMap(Collection::stream)
                .toList();
        List<Vehicle> flattingMapVehicles = nestedVehicleList
                .stream()
                .collect(Collectors.flatMapping(Collection::stream, Collectors.toList()));

        /*
          findAny / findFirst
          1. Stream with findAny and findFirst
          2. ParallelStream with findAny and findFirst
         */
        Optional<Vehicle> streamFindAny = getVehicles()
                .stream()
                .filter(vehicle -> "Mercedes".equals(vehicle.getCompany())).findAny();

        Optional<Vehicle> streamFindFirst = getVehicles()
                .stream()
                .filter(vehicle -> "Mercedes".equals(vehicle.getCompany())).findFirst();

        Optional<Vehicle> parallelStreamFindAny = getVehicles()
                .parallelStream()
                .filter(vehicle -> "Mercedes".equals(vehicle.getCompany())).findAny();

        Optional<Vehicle> parallelStreamFindFirst = getVehicles()
                .stream()
                .filter(vehicle -> "Mercedes".equals(vehicle.getCompany())).findFirst();

        /*
          1. Reduce for integers
          2. Reduce for strings
         */
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9 , 10);
        Integer factorial = integers.stream().reduce(1, (a, b) -> a * b);

        List<String> strings = List.of("aBa", "BBb", "cdA", "deF", "ZEDc");
        String formatted = strings.stream().reduce("", (a,b) -> {
            if (!"".equals(a)) {
                return a + "|" + b;
            } else {
                return b;
            }
        });
        print(formatted);
    }

    /*
     refactor
     intStream()
    */
    public static HashMap<Character, Integer> showOccurrences(String input) {

        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        for(int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            int count = 0;

            if(result.containsKey(c)) {
                count = result.get(c);
            }

            result.put(c, count + 1);
        }
        return result;

    }
}
