package excelUtilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils {
	private static FileInputStream fi;
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	
	public excelUtils(String sheetName,String readPath) {
		try {
			fi = new FileInputStream(readPath);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet(sheetName);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
//			e.printStackTrace();
		}
	}
	
	public String getData(int row,int cell){ 
		String data = "";
		try {
			data = sheet.getRow(row).getCell(cell).getStringCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
//			e.printStackTrace();
		}
		return data;
	}
	
	public int getLastRow() {
		int rowNum = 0;
		try {
			rowNum = sheet.getLastRowNum();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
//			e.printStackTrace();
		}
		return rowNum;
	}
	
	public int getLastCell(int row) {
		int cellNum = 0;
		try {
			cellNum = sheet.getRow(row).getLastCellNum();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
//			e.printStackTrace();
		}
		return cellNum;
	}
	
}
