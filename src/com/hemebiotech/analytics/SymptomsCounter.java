package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class SymptomsCounter implements ISymptomCounter{

    private String fileName;

    public SymptomsCounter(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Counter Method
      * @param symptoms
     */
    public void symptomsCounter(TreeMap<String, Integer> symptoms) {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                symptoms.put(line, symptoms.getOrDefault(line, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
