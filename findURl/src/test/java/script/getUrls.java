package script;

import generic.openbrowser;
import generic.stats;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getUrls extends openbrowser {
	
	@Test
	public void find() {

		String urls;
		excel file = new excel(setPath, sheetName);

		List<WebElement> elements = driver.findElements(By.tagName("a"));
		test.info("All the <a> elements are fetched");

		List<String> list = new ArrayList<>();
		for (WebElement ele : elements) {
			urls = ele.getAttribute("href");
			if (urls != null) {
				list.add(urls);
			}
		}
		List<String> status = stats.statCode(list);
		for (int row = 0; row < list.size(); row++) {
				excel.setData(row, list.get(row),status.get(row));
		}
		test.pass("All URls are Listed in the Excel file.");
	}
}
