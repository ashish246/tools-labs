package com.opencsv.demo;

import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class CSVMappedToJavaBeanExample {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		CsvToBean csv = new CsvToBean();

		String csvFilename = "src/main/java/com/opencsv/data/data.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));

		// Set column mapping strategy
		List list = csv.parse(setColumMapping(), csvReader);

		for (Object object : list) {
			Employee employee = (Employee) object;
			System.out.println(employee);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static ColumnPositionMappingStrategy setColumMapping() {
		ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
		strategy.setType(Employee.class);
		String[] columns = new String[] { "id", "firstName", "lastName",
				"country", "age" };
		strategy.setColumnMapping(columns);
		return strategy;
	}

}
