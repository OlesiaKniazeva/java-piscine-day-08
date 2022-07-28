package edu.school21.renderer;

import edu.school21.preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {
    private PreProcessor preProcessor;
    String newData;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    public void printData(String data) {
        newData = preProcessor.changeCase(data);
        System.err.println(newData);
    }
}
