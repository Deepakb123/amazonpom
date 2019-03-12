package utility;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;
	
	public ExcelDataConfig(String excelPath) {
		
		try 
		{
			File src=new File(excelPath);
			FileInputStream fp=new FileInputStream(src);
			wb=new XSSFWorkbook(fp);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetNumber,int row,int column) {
		
		sheet = wb.getSheetAt(sheetNumber);
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	
	public int getRowCount(int sheetIndex) {
		
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		return row+1;
		
	}
	

}
