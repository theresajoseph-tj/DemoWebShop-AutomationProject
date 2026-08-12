package Utility;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Workbook workbook;
	private static Sheet sheet;

	// Change the path according to your project
	private static String path = "src/test/resources/demowebshopregister.xlsx";

	// Open Excel File
	public static void openExcel(String sheetName) throws Exception {

		FileInputStream fis = new FileInputStream(path);

		workbook = new XSSFWorkbook(fis);

		sheet = workbook.getSheet(sheetName);
	}

	// Get Total Row Count
	public static int getRowCount() {

		return sheet.getLastRowNum();
	}

	// Read Cell Data
	public static String getCellData(int rowNum, int colNum) {

		if (sheet == null) {
			return "";
		}

		Row row = sheet.getRow(rowNum);

		if (row == null) {
			return "";
		}

		Cell cell = row.getCell(colNum);

		if (cell == null) {
			return "";
		}

		DataFormatter formatter = new DataFormatter();

		return formatter.formatCellValue(cell);
	}

	// Write Data into Excel
	public static void setCellData(int rowNum, int colNum, String value) {

		Row row = sheet.getRow(rowNum);

		if (row == null) {
			row = sheet.createRow(rowNum);
		}

		Cell cell = row.getCell(colNum);

		if (cell == null) {
			cell = row.createCell(colNum);
		}

		cell.setCellValue(value);
	}

	// Save and Close Excel
	public static void saveAndClose() throws Exception {

		FileOutputStream fos = new FileOutputStream(path);

		workbook.write(fos);

		workbook.close();

		fos.close();
	}
}
