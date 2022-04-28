package org.course.utils;

import java.util.Arrays;

public class Printer {

    public static void print(Object... objects) {
        Arrays.stream(objects).forEach(System.out::println);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
