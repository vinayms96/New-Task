package excelUtilities;

import org.testng.annotations.DataProvider;

import generic.auto_constant;

public class callUtils implements auto_constant{

	@DataProvider(name = "userPass")
	public static Object[][] getUserPass() {
		excelUtils excel = new excelUtils(sheetName+1,readPath);
		
		int rowNum = excel.getLastRow();
		int cellNum = excel.getLastCell(0);
		
		Object data[][] = new Object[rowNum][cellNum];
		
		for(int row=1 ; row<=rowNum ; row++) {
			for(int cell = 0 ; cell<cellNum ;cell++) {
				data[row][cell] = excel.getData(row, cell);
			}
		}
		return data;
	}
}
