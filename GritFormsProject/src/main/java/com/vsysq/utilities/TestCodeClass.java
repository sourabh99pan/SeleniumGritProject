package com.vsysq.utilities;

import java.util.Map;

public class TestCodeClass {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		 Map<String, String>  mapValues = ExcelUtils.getExcelAsMap(
					System.getProperty("user.dir") + "\\TestData\\ToolsQAData.xlsx", "TestData",
					1);
	}

}
