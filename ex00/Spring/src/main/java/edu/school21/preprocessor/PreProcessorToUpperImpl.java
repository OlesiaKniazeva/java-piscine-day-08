package edu.school21.preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    public PreProcessorToUpperImpl() {

    }

    public String changeCase(String data) {
        return data.toUpperCase();
    }
}
