package com.poi.demo;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.record.CFRuleRecord.ComparisonOperator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;

public class FormattingExcelDemo {

	public static void main(String[] args) {
		// Blank workbook
		HSSFWorkbook workbook = new HSSFWorkbook();

		// Create a blank sheet
		HSSFSheet sheet = workbook.createSheet("Employee Data");

		// basedOnValue(sheet);

		// formatDuplicates(sheet);

		// shadeAlt(sheet);

		expiryInNext30Days(sheet);

		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(
					"src/main/java/com/poi/data/formatting_excel_demo.xls"));
			workbook.write(out);
			out.close();
			System.out
					.println("formatting_excel_demo.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Cell value is in between a certain range
	 * 
	 * @param sheet
	 */
	static void basedOnValue(Sheet sheet) {

		// Creating some random values
		sheet.createRow(0).createCell(0).setCellValue(84);
		sheet.createRow(1).createCell(0).setCellValue(74);
		sheet.createRow(2).createCell(0).setCellValue(50);
		sheet.createRow(3).createCell(0).setCellValue(51);
		sheet.createRow(4).createCell(0).setCellValue(49);
		sheet.createRow(5).createCell(0).setCellValue(41);

		SheetConditionalFormatting sheetCF = sheet
				.getSheetConditionalFormatting();

		// Condition 1: Cell Value Is greater than 70 (Blue Fill)
		ConditionalFormattingRule rule1 = sheetCF
				.createConditionalFormattingRule(ComparisonOperator.GT, "70");
		PatternFormatting fill1 = rule1.createPatternFormatting();
		fill1.setFillBackgroundColor(IndexedColors.BLUE.index);
		fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

		// Condition 2: Cell Value Is less than 50 (Green Fill)
		ConditionalFormattingRule rule2 = sheetCF
				.createConditionalFormattingRule(ComparisonOperator.LT, "50");
		PatternFormatting fill2 = rule2.createPatternFormatting();
		fill2.setFillBackgroundColor(IndexedColors.GREEN.index);
		fill2.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

		CellRangeAddress[] regions = { CellRangeAddress.valueOf("A1:A6") };

		sheetCF.addConditionalFormatting(regions, rule1, rule2);
	}

	/**
	 * Highlight duplicate values
	 * 
	 * @param sheet
	 */
	static void formatDuplicates(Sheet sheet) {
		sheet.createRow(0).createCell(0).setCellValue("Code");
		sheet.createRow(1).createCell(0).setCellValue(4);
		sheet.createRow(2).createCell(0).setCellValue(3);
		sheet.createRow(3).createCell(0).setCellValue(6);
		sheet.createRow(4).createCell(0).setCellValue(3);
		sheet.createRow(5).createCell(0).setCellValue(5);
		sheet.createRow(6).createCell(0).setCellValue(8);
		sheet.createRow(7).createCell(0).setCellValue(0);
		sheet.createRow(8).createCell(0).setCellValue(2);
		sheet.createRow(9).createCell(0).setCellValue(8);
		sheet.createRow(10).createCell(0).setCellValue(6);

		SheetConditionalFormatting sheetCF = sheet
				.getSheetConditionalFormatting();

		// Condition 1: Formula Is =A2=A1 (White Font)
		ConditionalFormattingRule rule1 = sheetCF
				.createConditionalFormattingRule("COUNTIF($A$2:$A$11,A2)>1");
		FontFormatting font = rule1.createFontFormatting();
		font.setFontStyle(false, true);
		font.setFontColorIndex(IndexedColors.BLUE.index);

		CellRangeAddress[] regions = { CellRangeAddress.valueOf("A2:A11") };

		sheetCF.addConditionalFormatting(regions, rule1);

		sheet.getRow(2)
				.createCell(1)
				.setCellValue(
						"<== Duplicates numbers in the column are highlighted.  "
								+ "Condition: Formula Is =COUNTIF($A$2:$A$11,A2)>1   (Blue Font)");
	}

	/**
	 * Color alternate rows in different colors
	 * 
	 * @param sheet
	 */
	static void shadeAlt(Sheet sheet) {
		SheetConditionalFormatting sheetCF = sheet
				.getSheetConditionalFormatting();

		// Condition 1: Formula Is =A2=A1 (White Font)
		ConditionalFormattingRule rule1 = sheetCF
				.createConditionalFormattingRule("MOD(ROW(),2)");
		PatternFormatting fill1 = rule1.createPatternFormatting();
		fill1.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.index);
		fill1.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

		CellRangeAddress[] regions = { CellRangeAddress.valueOf("A1:Z100") };

		sheetCF.addConditionalFormatting(regions, rule1);

		sheet.createRow(0).createCell(1).setCellValue("Shade Alternating Rows");
		sheet.createRow(1)
				.createCell(1)
				.setCellValue(
						"Condition: Formula Is  =MOD(ROW(),2)   (Light Green Fill)");
	}

	/**
	 * Color amounts which are going to expire in next 30 days
	 * 
	 * @param sheet
	 */
	static void expiryInNext30Days(Sheet sheet) {
		CellStyle style = sheet.getWorkbook().createCellStyle();
		style.setDataFormat((short) BuiltinFormats.getBuiltinFormat("d-mmm"));

		sheet.createRow(0).createCell(0).setCellValue("Date");
		sheet.createRow(1).createCell(0).setCellFormula("TODAY()+29");
		sheet.createRow(2).createCell(0).setCellFormula("A2+1");
		sheet.createRow(3).createCell(0).setCellFormula("A3+1");

		for (int rownum = 1; rownum <= 3; rownum++)
			sheet.getRow(rownum).getCell(0).setCellStyle(style);

		SheetConditionalFormatting sheetCF = sheet
				.getSheetConditionalFormatting();

		// Condition 1: Formula Is =A2=A1 (White Font)
		ConditionalFormattingRule rule1 = sheetCF
				.createConditionalFormattingRule("AND(A2-TODAY()>=0,A2-TODAY()<=30)");
		FontFormatting font = rule1.createFontFormatting();
		font.setFontStyle(false, true);
		font.setFontColorIndex(IndexedColors.BLUE.index);

		CellRangeAddress[] regions = { CellRangeAddress.valueOf("A2:A4") };

		sheetCF.addConditionalFormatting(regions, rule1);

		sheet.getRow(0).createCell(1)
				.setCellValue("Dates within the next 30 days are highlighted");
	}
}
