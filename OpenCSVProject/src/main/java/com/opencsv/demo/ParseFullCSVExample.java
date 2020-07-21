package com.opencsv.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ParseFullCSVExample {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		parseFullCSV();

		ParseCSVLineByLine();
	}

	public static void parseFullCSV() throws Exception {
		// Build reader instance
		CSVReader reader = new CSVReader(new FileReader(
				"src/main/java/com/opencsv/data/data.csv"), ',', '"', 1);

		// Read all rows at once
		List<String[]> allRows = reader.readAll();

		// Read CSV line by line and use the string array as you want
		for (String[] row : allRows) {
			System.out.println(Arrays.toString(row));
		}
	}

	@SuppressWarnings("resource")
	public static void ParseCSVLineByLine() {
		// Build reader instance
		// Read data.csv
		// Default seperator is comma
		// Default quote character is double quote
		// Start reading from line number 2 (line numbers start from zero)
		try {
			CSVReader reader;
			reader = new CSVReader(new FileReader(
					"src/main/java/com/opencsv/data/data.csv"), ',', '"', 1);

			// Read CSV line by line and use the string array as you want
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null) {
					// Verifying the read data here
					System.out.println(Arrays.toString(nextLine));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
