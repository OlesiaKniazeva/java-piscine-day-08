package edu.school21.preprocessor;

public class PreProcessorToLowerImpl implements PreProcessor {
    public PreProcessorToLowerImpl() {

    }

    public String changeCase(String data) {
        return data.toLowerCase();
    }
}
