package edu.school21.program;

import edu.school21.preprocessor.PreProcessorToLowerImpl;
import edu.school21.printer.Printer;
import edu.school21.printer.PrinterWithDateTimeImpl;
import edu.school21.printer.PrinterWithPrefixImpl;
import edu.school21.preprocessor.PreProcessor;
import edu.school21.preprocessor.PreProcessorToUpperImpl;
import edu.school21.renderer.Renderer;
import edu.school21.renderer.RendererErrImpl;

import edu.school21.renderer.RendererStandardImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Printer printer = context.getBean("printer-date-std-upper", Printer.class);
        printer.print("Hello!");

        Printer printer1 = context.getBean("ppel", Printer.class);
        printer1.print("NNo");

        {
            PreProcessor preProcessor = new PreProcessorToUpperImpl();
            Renderer renderer = new RendererErrImpl(preProcessor);
            PrinterWithPrefixImpl printer3 = new PrinterWithPrefixImpl(renderer);
            printer3.setPrefix("Prefix ");
            printer3.print("Hello!");
        }

        {
            PreProcessor preProcessor = new PreProcessorToLowerImpl();
            Renderer renderer = new RendererStandardImpl(preProcessor);
            PrinterWithDateTimeImpl printer3 = new PrinterWithDateTimeImpl(renderer);
            printer3.print("Hello!");
        }
    }
}

