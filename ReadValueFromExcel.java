package salesforce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadValueFromExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook ex = new XSSFWorkbook("./Exceldata/jp excel.xlsx");
         XSSFSheet shee = ex.getSheetAt(0);
         //ROWCOUNT
         int lRNum = shee.getLastRowNum();
         System.out.println("rowcount:"+lRNum);
         //INCLUDE HEADER PART COUNT
         int rows = shee.getPhysicalNumberOfRows();
         System.out.println("rowhead count:"+rows);
         //column count = here its cell count
         short num = shee.getRow(1).getLastCellNum();
         System.out.println("cellcount :"+ num);
         //print Any values
         String value = shee.getRow(3).getCell(3).getStringCellValue();
         System.out.println(value);
         //all values want it
         for (int i = 1; i <=lRNum; i++) {
    
        	 for (int j = 0; j < num; j++) {
        	String stringCellValue = shee.getRow(i).getCell(j).getStringCellValue();
        		 System.out.println(stringCellValue);
				
			}
			
		}
         
        ex.close();
         
         
	}}


