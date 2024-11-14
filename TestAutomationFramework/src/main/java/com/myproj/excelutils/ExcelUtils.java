package com.myproj.excelutils; // Update the package name as per your project structure

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtils {

    // Method to read Excel data
    public void readExcelData(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new HSSFWorkbook (fis)) {  // Opens the workbook

            // Access the specified sheet
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Sheet " + sheetName + " not found");
                return;
            }

            // Iterate through the rows
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()) {
                Row row = rows.next();

                // Iterate through the cells of each row
                Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown Type\t");
                    }
                }
                System.out.println();  // Move to the next line for a new row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testReadExcelData() {
        String filePath = "path/to/your/excel-file.xlsx"; // Update this with your actual file path
        String sheetName = "sheet1"; // Change to your actual sheet name

        // Call the method to read Excel data
        readExcelData(filePath, sheetName);
    }
}
