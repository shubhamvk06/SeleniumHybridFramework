package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path) {
		this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException{
	
		
		 fi = new FileInputStream(path); // Load the file
	        workbook = new XSSFWorkbook(fi); // Load the workbook
	        sheet = workbook.getSheet(sheetName); // Load the sheet by name
	        int rowCount = sheet.getLastRowNum(); // Get the last row index
	        workbook.close(); // Close the workbook
	        fi.close(); // Close the file input stream

	        return rowCount ;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException{
		fi = new FileInputStream(path); // Load the Excel file
	    workbook = new XSSFWorkbook(fi); // Load the workbook
	    sheet = workbook.getSheet(sheetName); // Load the sheet by name

	    

	    row = sheet.getRow(rownum); // Get the specified row
	    if (row == null) {
	        workbook.close();
	        fi.close();
	        return 0; // If the row doesn't exist, return 0
	    }

	    int cellCount = row.getLastCellNum(); // Get the number of cells (columns) in the row
	    workbook.close(); // Close the workbook
	    fi.close(); // Close the file input stream

	    return cellCount;
	}
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException{
		fi = new FileInputStream(path); // Load the Excel file
	    workbook = new XSSFWorkbook(fi); // Load the workbook
	    sheet = workbook.getSheet(sheetName); // Load the sheet by name

	    

	    row = sheet.getRow(rownum); // Get the specified row
	    if (row == null) {
	        workbook.close();
	        fi.close();
	        return ""; // If the row doesn't exist, return an empty string
	    }

	    cell = row.getCell(colnum); // Get the specified cell
	    if (cell == null) {
	        workbook.close();
	        fi.close();
	        return ""; // If the cell doesn't exist, return an empty string
	    }
	    DataFormatter formatter = new DataFormatter();
	    String data;
	    try {
	    	data = formatter.formatCellValue(cell);// Returns formatted value of a cell as string
	    }catch(Exception e) {
	    	data =  "";
	    }

	    workbook.close(); // Close the workbook
	    fi.close(); // Close the file input stream

	    return data;
	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException{
		File xlfile = new File(path);
		if(!xlfile.exists()) //if file does not exist create new file
		{
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
		}
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		
		
		if(workbook.getSheetIndex(sheetName)==-1)// if sheet does not exist then create new sheet
		
			workbook.createSheet(sheetName);
			sheet = workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null)// if sheet does not exist then create new sheet
				
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
			
	}
	
	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException{
		 fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);

	        

	        row = sheet.getRow(rownum);
	        if (row == null) {
	            row = sheet.createRow(rownum);
	        }

	        cell = row.getCell(colnum);
	        if (cell == null) {
	            cell = row.createCell(colnum);
	        }

	        CellStyle style = workbook.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	        cell.setCellStyle(style);

	        //fo = new FileOutputStream(path);
	        workbook.write(fo);

	        workbook.close();
	        fi.close();
	        fo.close();
	    }
	
	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException{
		 fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);

	        

	        row = sheet.getRow(rownum);
	        if (row == null) {
	            row = sheet.createRow(rownum);
	        }

	        cell = row.getCell(colnum);
	        if (cell == null) {
	            cell = row.createCell(colnum);
	        }

	        CellStyle style = workbook.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.RED.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	        cell.setCellStyle(style);

	        //fo = new FileOutputStream(path);
	        workbook.write(fo);

	        workbook.close();
	        fi.close();
	        fo.close();
	    }

	    
	
}
