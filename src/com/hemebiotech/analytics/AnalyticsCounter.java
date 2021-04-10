package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * Main class
 **/
public class AnalyticsCounter {
	/**
	 * Main function (not modified)
	 **/
	public static void main(String args[]){

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		TreeMap<String, Integer> resultSymptoms = reader.getSymptoms();

		SymptomsCounter counter = new SymptomsCounter("symptoms.txt");
		counter.symptomsCounter(resultSymptoms);

		WriterCountSymptoms  writer = new WriterCountSymptoms("result.out");
		writer.symptomsWriter(resultSymptoms);
		}
	}