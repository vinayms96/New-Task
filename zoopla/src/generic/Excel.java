package generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public String getData(String sourcePath,String newSheet,int row, int col) {
		String res="";
		try {
			FileInputStream fi = new FileInputStream(sourcePath);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			res = wb.getSheet(newSheet).getRow(row).getCell(col).getStringCellValue();
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int getLastRow(String sourcePath,String newSheet,int row, int col) {
		int res=0;
		try {
			FileInputStream fi = new FileInputStream(sourcePath);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			res = wb.getSheet(newSheet).getLastRowNum();
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
