package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path = ".\\testData\\opencart_logindata.xlsx";
		
		ExcelUtility xlutil = new  ExcelUtility(path);
		
		int totalrows = xlutil.getRowCount(path);
		int totalcols = xlutil.getRowCount(path);
		
		String logindata[][] = new String[totalrows][totalcols];
		
		for(int i = 1;i<=totalrows;i++) {
			for(int j=0; j<totalcols; j++) {
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
	}

}
