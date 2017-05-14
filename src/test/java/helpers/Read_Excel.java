package helpers;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {
	
	//Workbook wrkbook = null;
	//Sheet sheet = null;
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public Read_Excel(String excelpath)  {
		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	 public String getData(String sheetName, int row, int column)
	 {
		 sheet1 = wb.getSheet(sheetName);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	 }

}
