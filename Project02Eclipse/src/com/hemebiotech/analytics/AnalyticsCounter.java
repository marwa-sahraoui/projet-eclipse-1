package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {
		
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));

	
		
		ReadSymptomDataFromFile myReader = new ReadSymptomDataFromFile("symptoms.txt");
		
		
		//1. list l'ensemble des données de symptome dans la source (le fichier) et les met dans une liste Java
		List<String> listSymptoms = myReader.GetSymptoms();
		
		
		//2. Ce traitement retourne une map avec pour chaque symptome son nombre d'occurance 
		Map<String, Integer> mySymptomsOccrrenceMap = myReader.nbSymtomFromJavaList(listSymptoms);
		
		
		//3. Trier par ordre alphabétique le dictionnaire des symptome
		
		
		//4. Ecrire le dictionnaire des symptomes et meurs occurrence dans un fichioer de sortie
		
		
		myReader.writeDictionaryFile(mySymptomsOccrrenceMap, "result.txt");
	
	}

}
