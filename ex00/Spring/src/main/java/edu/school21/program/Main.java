package edu.school21.program;

import edu.school21.printer.Printer;
import edu.school21.printer.PrinterWithPrefixImpl;
import edu.school21.preprocessor.PreProcessor;
import edu.school21.preprocessor.PreProcessorToUpperImpl;
import edu.school21.renderer.Renderer;
import edu.school21.renderer.RendererErrImpl;

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

//        PreProcessor preProcessor = new PreProcessorToUpperImpl();
//        Renderer renderer = new RendererErrImpl(preProcessor);
//        PrinterWithPrefixImpl printer3 = new PrinterWithPrefixImpl(renderer);
//        printer3.setPrefix ("Prefix ");
//        printer3.print ("Hello!");
    }
}

