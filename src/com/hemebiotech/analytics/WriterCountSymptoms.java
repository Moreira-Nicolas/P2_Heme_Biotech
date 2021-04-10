package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriterCountSymptoms implements ISymptomWriter {

    private String fileName;

    public WriterCountSymptoms() {
        this.fileName= "default.out";
    }

    public WriterCountSymptoms(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Writer method
     */
    public void symptomsWriter(TreeMap<String, Integer> symptoms) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(this.fileName))) {

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                bf.write(entry.getKey() + "=" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
