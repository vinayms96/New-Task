package utils;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import generic.openbrowser;

public class excel extends openbrowser {
	public FileInputStream fi;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;

	public excel(String path, String name) {
		try {
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getData(int row, int cell) {
		String data = "";
		try {
			data = sheet.getRow(row).getCell(cell).getStringCellValue();
		} catch (Exception e) {
			test.fail("Failed to return the Data from the File");
		}
		return data;
	}

	public int rowCount() {
		int rowNum = 0;
		try {
			rowNum = sheet.getLastRowNum();
		} catch (Exception e) {
			test.fail("Failed to return the Last row number of the sheet");
		}
		test.info("Last row number is returned");
		return rowNum;
	}
	
	public int cellCount() {
		int colNum=0;
		try {
			colNum = sheet.getRow(0).getLastCellNum();
			}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colNum;
	}

//	public void writeData(List<WebElement> dataToSave,int last) {
//		int cell = 0,count=last;
//		try {
//			for (int row = last; row < dataToSave.size(); row++) {
//				
//				if (dataToSave.get(row).getAttribute("href") != null) {
//					System.out.println(dataToSave.get(row).getAttribute("href"));
//					sheet.createRow(count).createCell(cell).setCellValue(dataToSave.get(row).getAttribute("href"));
//					count++;
//				}
//			}
//			FileOutputStream fo = new FileOutputStream(readPath);
//			wb.write(fo);
//			fo.close();
//		} catch (Exception e) {
//			test.fail("Failed to Write data into an Excel file");
//		}
//	}
	
	

}
