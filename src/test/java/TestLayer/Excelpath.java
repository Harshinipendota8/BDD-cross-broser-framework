package TestLayer;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelpath {

	
		XSSFWorkbook workbook;
		
		public Excelpath(String excelPath) throws Exception {
			// step 1:: check file is present or not by creating object of File class and by
			// passing
			// file location
			File f = new File(excelPath);
			// step 2:: read all file content by creating object of FileInputStream and by
			// passing File class Instance
			FileInputStream fis = new FileInputStream(f);
			// step 3: load the all work sheet by creating object of XSSFWorkbook and by
			// passing FileInputStream instance
			workbook = new XSSFWorkbook(fis);
		}
		
		public int getTotalRowCount(int sheetIndex)
		{
				XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				int rows = sheet.getLastRowNum()+1;
				return rows;
		}

		public int getTotalColumnCount(int sheetIndex)
		{
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			int cells = sheet.getRow(0).getLastCellNum();
			return cells;
		}


		
		public Object getSheetTestData(int sheetIndex, int row, int cell)
		{
			//step 1: focus on specific sheet
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			
			//step 2: focus on specific cell
			XSSFCell cells = sheet.getRow(row).getCell(cell);
			
			//Step 3: check which type of value is present inside the cell
			//if cell is blank then return blank space
			if(cells.getCellType() == CellType.BLANK)//myCell.getCellType() == CellType.BLANK
			{
				return "";
			}
			//if cell value type is String then return the String value
			else if(cells.getCellType() == CellType.STRING)
			{
				//Step 4: capture the String cell value
				String a = cells.getStringCellValue();
				return a;
			}
			//if cell value type is numeric then return the numeric value
			else if(cells.getCellType() == CellType.NUMERIC)
			{
				//step 5: capture the numeric cell value
				String b = cells.getRawValue();
				return b;
			}
			//if cell value type is boolean then return the boolean value
			else if(cells.getCellType()== CellType.BOOLEAN)
			{
				boolean c = cells.getBooleanCellValue();
				return c;
			}
			//if cell value type is formula then return the formula value
			else if(cells.getCellType() == CellType.FORMULA)
			{
				String d = cells.getCellFormula();
				return d;
			}
			
			//if above values are not matches then return the null.
			return null;
		}
		
		public Object [][] getAllSheetTestData(int sheetIndex )
		{
				//count total rows in sheet
				int rows = getTotalRowCount(sheetIndex);
				//count total columns in sheet
				int cells = getTotalColumnCount(sheetIndex);

				//create Object[][] array with same rows and same columns
				
				Object[] [] data = new Object[rows] [cells];

			 	//iterate all rows 
				for(int i=0;i<rows; i++)
				{
					//iterate the columns
					for(int j=0; j< cells; j++)
					{
							//capture all values from excel sheet and store in Object [][] array.
							data [i][j] =getSheetTestData(sheetIndex, i ,j);
					}
				}


			return data;

		

		}


	}


