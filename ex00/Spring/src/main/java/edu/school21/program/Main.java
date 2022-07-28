package edu.school21.program;

import edu.school21.printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Printer printer = context.getBean("pdsup", Printer.class);
        printer.setPrefix(LocalDateTime.now());
        printer.print("Hello!");

        Printer printer1 = context.getBean("ppsl", Printer.class);
        printer1.setPrefix("Lets go!");
        printer1.print("NNo");
    }
}

