package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import generic.stats;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import generic.openbrowser;

public class excel extends openbrowser {
	public FileInputStream fi;
	public static Workbook wb;
	public static Sheet sheet;

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
	
	/*public static void setData(int row,int cell,Object data,Workbook wb,Sheet sheet) {
		try {
			XSSFRow rowNum = (XSSFRow) sheet.getRow(row);
			if(rowNum == null) {
				rowNum = (XSSFRow) sheet.createRow(row);
			}
			Cell cellVal = rowNum.createCell(cell);
//			Cell cellVal = sheet.getRow(row).getCell(cell);
			FileOutputStream fo = new FileOutputStream(setPath);
			if(cellVal.getCellTypeEnum() == CellType.STRING) {
				cellVal.setCellValue((String)data);
				wb.write(fo);
			}else if(cellVal.getCellTypeEnum() == CellType.NUMERIC) {
				cellVal.setCellValue((Integer)data);
				wb.write(fo);
			}
			fo.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

	public static void setData(int row, String data,String stats){
				try {
					FileOutputStream fo = new FileOutputStream(setPath);
					Row  r = sheet.createRow(row);
					r.createCell(0).setCellValue(data);
					r.createCell(1).setCellValue(stats);
					wb.write(fo);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
