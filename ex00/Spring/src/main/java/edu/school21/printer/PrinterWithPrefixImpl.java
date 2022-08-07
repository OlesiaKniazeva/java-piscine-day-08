package edu.school21.printer;

import edu.school21.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private String prefix;
    private Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        prefix = "";
        this.renderer = renderer;
    }

    public PrinterWithPrefixImpl(String prefix, Renderer renderer) {
        this.prefix = prefix;
        this.renderer = renderer;
    }

    public void setPrefix(String data) {
        prefix += data.toString();
    }
    public void print(String data) {
        String result = prefix + " " + data;
        renderer.printData(result);
    }
}
