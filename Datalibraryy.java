package salesforce;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datalibraryy{
//step 4
//if we remove or retain the static keyword and main method to normal method we reuse the code
//common reference=static so this one program we used in multiple testcases
	public static String[][] readvalue() throws IOException {
		XSSFWorkbook ex = new XSSFWorkbook("./Exceldata/jp excel.xlsx");
        XSSFSheet shee = ex.getSheetAt(0);
        int RNum = shee.getLastRowNum();
        short cnum = shee.getRow(1).getLastCellNum();
        
        //step1
        //assign and declare the value
        String[][]data=new String[RNum][cnum];
        for (int i = 1; i <=RNum; i++) {
       	 
       	 for (int j = 0; j < cnum; j++) {
       	String stringCellValue = shee.getRow(i).getCell(j).getStringCellValue();
       	
       	
       	//step 2
  //what are the data im reading from excel sheet im going to assign the value to
  //the data provider starts index from 0 so im giving i-1[excel change dataprovider]
       	data[i-1][j]=stringCellValue;
	}
       //step 3
       	 ex.close();
}
		return data;
	}}
