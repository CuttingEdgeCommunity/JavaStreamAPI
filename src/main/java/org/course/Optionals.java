package org.course;

import org.course.utils.DataFactory;

import static org.course.utils.DataFactory.optionalListEmpty;
import static org.course.utils.DataFactory.optionalListNotEmpty;
import static org.course.utils.Printer.print;

public class Optionals {
    public static void main(String[] args) {

        //get - bad idea
        optionalListNotEmpty().get();
        optionalListEmpty().get();

        //isPresent
        optionalListNotEmpty().isPresent();
        optionalListEmpty().isPresent();

        //orElse
        optionalListNotEmpty().orElse(DataFactory.emptyList());
        optionalListEmpty().orElse(DataFactory.emptyList());

        //orElseGet
        optionalListNotEmpty().orElseGet(DataFactory::emptyList);
        optionalListEmpty().orElseGet(DataFactory::emptyList);

        //orElseThrow
        try {
            optionalListEmpty().orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //orElseThrow with custom message
        try {
            optionalListEmpty().orElseThrow(() -> new Exception("Optional list is empty"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
