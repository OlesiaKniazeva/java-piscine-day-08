package edu.school21.printer;

import edu.school21.renderer.Renderer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrinterWithDateTimeImpl implements Printer {
    private Renderer renderer;

    private String prefix;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        prefix = currentTime();
        this.renderer = renderer;
    }

    private String currentTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return time.format(formatter);
    }

    public void print(String data) {
        String result = prefix + " " + data;
        renderer.printData(result);
    }
}
