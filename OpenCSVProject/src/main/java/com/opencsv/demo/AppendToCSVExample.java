package com.opencsv.demo;

import java.io.FileWriter;

import au.com.bytecode.opencsv.CSVWriter;

public class AppendToCSVExample {

	public static void main(String[] args) throws Exception {
		String csv = "src/main/java/com/opencsv/data/data.csv";
		CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

		String[] record = "3,David,Feezor,USA,40".split(",");

		writer.writeNext(record);

		writer.close();
	}
}
