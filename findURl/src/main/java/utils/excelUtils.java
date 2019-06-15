package utils;

import org.testng.annotations.DataProvider;

import generic.auto_constant;

public class excelUtils implements auto_constant {
	
	@DataProvider(name = "getTwoRowData")
	public static Object[][] getTwoData() {
		excel ex = new excel(readPath, sheetName);
		
		int rowNum = ex.rowCount();
		int cellNum = ex.cellCount();
		
		Object data[][] = new Object[rowNum][cellNum];
		
		for(int row=1;row<rowNum;row++) {
			for(int cell=0;cell<cellNum;cell++) {
				data[row][cell] = ex.getData(row, cell);
			}
		}
		return data;
	}
	
}
