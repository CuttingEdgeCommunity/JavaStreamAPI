package org.course;

import org.course.utils.Printer;

import java.sql.Timestamp;
import java.util.List;

import static org.course.utils.Printer.print;

/**
 * Lambda expression is an anonymous function, without any name or identifier,
 * (argument-list) -> {body}
 */
public class Lambda {
    public static void main(String[] args) {
        /*
            Write print all the numbers within the list
        */
        List<Integer> numbers = List.of(1, 2, 3);
        numbers.forEach(Printer::print);


        /*
            Implement CustomFunctionalInterface, so it would print out massages with the timestamp
        */
        CustomFunctionalInterface timeStampPrinter = (String a) -> {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            print(timestamp + " " + a);
        };
        timeStampPrinter.evaluate("argument");


        /*
            Use Thread.start() to start a new thread and print String message from it
        */
        String message = "Message from another thread";
        new Thread(() -> print(Thread.currentThread() + message)).start();
    }
}

@FunctionalInterface
interface CustomFunctionalInterface {
    void evaluate(String arg);
}
