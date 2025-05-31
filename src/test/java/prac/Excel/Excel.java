package prac.Excel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import prac.Base.Base;



	public class Excel extends Base {  
	     
	  @Test
	  public void testMethod() { 
	       System.out.print("");  
	  }
	

	
	@DataProvider(name = "excelDataProvider")
	 public Object[][] excelDataProvider() {
	 List<Object[]> data = new ArrayList<>();
	 try {
	 FileInputStream file = new
	FileInputStream("src/test/resources/testData.xlsx");
	 XSSFWorkbook workbook = new XSSFWorkbook(file);
	 XSSFSheet sheet = workbook.getSheetAt(0);
	 for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	 Row row = sheet.getRow(i);
	 String username = getCellValue(row.getCell(0));
	 String password = getCellValue(row.getCell(1));
	 data.add(new Object[]{username, password});
	 }
	 workbook.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 return data.toArray(new Object[0][]);
	 }
	private String getCellValue(Cell cell) {
	 if (cell == null) {
	 return "";
	 }
	 switch (cell.getCellType()) {
	 case STRING:
	 return cell.getStringCellValue();
	 case NUMERIC:
	 return String.valueOf((long) cell.getNumericCellValue());
	 case BOOLEAN:
	 return String.valueOf(cell.getBooleanCellValue());
	 case BLANK:
	 return "";
	 default:
	 throw new IllegalArgumentException("Unsupported cell type");
	 }
	 }
	@Test(dataProvider = "excelDataProvider")
	 public void excelTestMethod(String username, String password) {
	 System.out.println("Username: " + username + ", Password: " + password);

	 }
	@DataProvider(name = "csvDataProvider")
	 public Object[][] csvDataProvider() {
	 String csvFile = "src/test/resources/test.csv";
	 List<Object[]> data = new ArrayList<>();
	 String line;
	 try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	 while ((line = br.readLine()) != null) {
	 String[] values = line.split(",");
	 data.add(values);
	 }
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 return data.toArray(new Object[0][]);
	}
	
}

