package edu.school21.printer;

import edu.school21.renderer.Renderer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrinterWithDateTimeImpl implements Printer {
    private String prefix;
    private Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        prefix = "";
        this.renderer = renderer;
    }

    public void setPrefix(Object data) {
        LocalDateTime time = (LocalDateTime) data;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedString = time.format(formatter);
        prefix += formattedString;
    }
    public void print(String data) {
        String result = prefix + " " + data;
        renderer.printData(result);
    }
}
