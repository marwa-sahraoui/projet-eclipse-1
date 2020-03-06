package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Map<String, Integer> nbSymtomFromJavaList(List<String> mySymptomsList) {

		Map<String, Integer> resultat = new HashMap<String, Integer>();

		for (String currentSymptom : mySymptomsList) {

			int numberOfCurentSymptomIngivenList = Collections.frequency(mySymptomsList, currentSymptom);

			resultat.put(currentSymptom, numberOfCurentSymptomIngivenList);

		}

		TreeMap<String, Integer> sortedMap = new TreeMap<>(resultat);

		return sortedMap;

	}

	public void writeDictionaryFile(Map<String, Integer> resultat, String fileName) throws Exception {

		FileWriter writer = new FileWriter(fileName);

		for (Map.Entry<String, Integer> entry : resultat.entrySet()) {

			System.out.println(entry.getKey() + " : " + entry.getValue());

			writer.write(entry.getKey() + " : " + entry.getValue() + "\n");

		}
		writer.close();
	}

}
