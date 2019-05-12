package scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.openbrowser;
import generic.stats;
import utils.excel;

public class getUrls extends openbrowser {

	public static XSSFWorkbook wb = new XSSFWorkbook();
	public static Sheet sheet = wb.createSheet("Sheet1");
	
	@Test
	public void find() throws InvalidFormatException, IOException {
		
		int cell = 0;
		String urls;
//		int count = 0;
//		excel file = new excel(readPath, sheetName);
//		writeExcel wrex = new writeExcel(sheetName);

		List<WebElement> elements = driver.findElements(By.tagName("a"));
//		test.info("All the <a> elements are fetched");
//		for(int i=0;i<elements.size();i++) {
//			String data = elements.get(i).getAttribute("href");
//			int statusCode = stats.statCode(data);
//			String statusMsg = stats.statMsg(data);
//			
//			for(int row=1;row<elements.size();row++) {
//				for(cell=0;cell<2;cell++) {
//					Object[][] al1 = {data,statusCode,statusMsg};
//					wrex.setData(row,cell,all);
//				}
//			
//			}

		List<String> list = new ArrayList<>();
		for (WebElement ele : elements) {
			urls = ele.getAttribute("href");
			if (urls != null) {
				list.add(urls);
			}
		}
		List<String> status = stats.statCode(list);
//		List<String> stMsg = stats.statMsg(list);
		for (int row = 0; row < list.size(); row++) {
			for (cell = 0; cell < 2; cell++) {
				Object[] obj1 = { list, status };
//				wrex.setData(obj1,readPath);
//				excel.setData(row, cell, obj1, wb,sheet);
			}
		}

//			if(data != null) {
//				System.out.println(data);
//				
//				count++;
//			}

		test.pass("All URls are Printed in the Excel file.");
//		ArrayList<String> al = new ArrayList<String>();
////		List<ArrayList<String>> convert = new ArrayList<ArrayList<String>>();
//		for(WebElement ele : elements) {
//			al.add(ele.getAttribute("href"));
//		}
//		for(int i=0;i<al.size();i++) {
//			file.writeData(i,cell, al);
//		}

	}

}

class urlData {
	String url;
	int statusCode;
	String statusMsg;

	public urlData() {

	}
}
