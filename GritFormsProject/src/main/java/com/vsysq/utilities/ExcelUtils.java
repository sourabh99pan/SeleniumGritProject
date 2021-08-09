package com.vsysq.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow) throws Exception

	{

		// String[][] tabArray = null;
		Object[][] arr = null;
		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			
			System.out.println(FilePath+SheetName+iTestCaseRow);
			int startCol = 1;

			int ci = 0, cj = 0;

			int totalRows = 1;

			//int totalCols1 = getCellCount(System.getProperty("user.dir") + "/TestData/E2EMPTestData.xlsx", "MPData",
					//iTestCaseRow);
			
			int totalCols1 = getCellCount(FilePath, SheetName,iTestCaseRow);
			
			int totalCols = totalCols1 - 1;
			System.out.println(totalCols);
			// tabArray=new String[totalRows][totalCols];
			arr = new Object[totalRows][totalCols];
			for (int j = startCol; j <= totalCols; j++, cj++)

			{

				// tabArray[ci][cj]=getCellData(iTestCaseRow,j);
				arr[ci][cj] = getCellData(iTestCaseRow, j);
				System.out.println(arr[ci][cj]);

			}

		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (arr);

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		// FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		 String CellData  = null;
		 
		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			//String CellData = Cell.getStringCellValue();
			
			//return CellData;
			//cell.getCellTypeEnum();
			System.out.println("Cell type is "+Cell.getCellTypeEnum());
				switch (Cell.getCellTypeEnum())
				{
				
			        case STRING:
			            
			             CellData = Cell.getStringCellValue();
			             System.out.println(CellData);
			             break;
			            
			        case NUMERIC:
			        	 CellData =   Double.toString(Cell.getNumericCellValue());
			        	 System.out.println(CellData);
			        	 break;

				}
			
			} 
		catch (Exception e) {
			 return "";

		}
		return CellData;
	}

	public static String getTestCaseName(String sTestCase) throws Exception {

		String value = sTestCase;

		try {

			int posi = value.indexOf("@");

			value = value.substring(0, posi);

			posi = value.lastIndexOf(".");

			value = value.substring(posi + 1);

			return value;

		} catch (Exception e) {

			throw (e);

		}

	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {

		int i;

		try {

			int rowCount = ExcelUtils.getRowUsed();

			for (i = 0; i < rowCount; i++) {

				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {

					break;

				}

			}

			return i;

		} catch (Exception e) {

			throw (e);

		}

	}

	public static int getRowUsed() throws Exception {

		try {

			int RowCount = ExcelWSheet.getLastRowNum();

			return RowCount;

		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}
	
	public static Map<String, String> getExcelAsMap(String FilePath, String SheetName, int iTestCaseRow) throws Throwable {
		FileInputStream ExcelFile = new FileInputStream(FilePath);

		// Access the required test data sheet

		XSSFWorkbook wb  = new XSSFWorkbook(ExcelFile);

		XSSFSheet sheet  = wb.getSheet(SheetName);
	    List<String> columnHeader = new ArrayList<String>();
	    Row row = sheet.getRow(0);
	    Iterator<Cell> cellIterator = row.cellIterator();
	    while (cellIterator.hasNext()) {
	    	//Cell cell = cellIterator.next();
	        columnHeader.add(cell.getStringCellValue());
	        
	        System.out.println(cell.getStringCellValue());
	    }
	    
	    int columnCount = row.getLastCellNum();

	    System.out.println(columnCount);
	        Map<String, String> singleRowData = new HashMap<String, String>();
	        for (int j = 0; j < columnCount; j++) {
	            //Cell cell = row.getCell(j);
	            //singleRowData.put(columnHeader.get(j), getCellData(iTestCaseRow, j));
	        	XSSFCell cellValue = sheet.getRow(iTestCaseRow).getCell(j);
	        	singleRowData.put(columnHeader.get(j), cellValue.toString());
	            System.out.println(cellValue);
	        }
			for(Entry m:singleRowData.entrySet())
			{
				System.out.println(m.getKey()+"  "+m.getValue());
			}
			Map<String, String> sMap
            = Collections.synchronizedMap(singleRowData);
	       return sMap;
	    
	    
	}
	
}
