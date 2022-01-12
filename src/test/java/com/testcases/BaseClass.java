package com.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class BaseClass {
	public Logger log = LogManager.getLogger();

	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_201 = 201;

	public Properties prop;

	public void TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@BeforeMethod
	public String getURL() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String baseURL = rb.getString("geturl");
		return baseURL;
	}

	@BeforeMethod
	public String getPostURL() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String baseURL = rb.getString("posturl");
		return baseURL;
	}

	@BeforeMethod
	public String getSimplebooksURL() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String baseURL = rb.getString("simplebksget");
		return baseURL;
	}

	@BeforeMethod
	public String getSimplebooksdeleteURL() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String baseURL = rb.getString("simplebksdeleteurl");
		return baseURL;
	}

	@BeforeMethod
	public String getbooksurl() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String baseURL = rb.getString("getbooksurl");
		return baseURL;
	}

	// Get Excel data
	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception {
		String[][] tabArray = null;
		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();
		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);
		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		/*
		 * System.out.println("startRow="+startRow+", endRow="+endRow+", " +
		 * "startCol="+startCol+", endCol="+endCol);
		 */
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;
		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}
		return (tabArray);
	}// TableArray
}
