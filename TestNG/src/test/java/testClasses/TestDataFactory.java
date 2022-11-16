package testClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;

public class TestDataFactory {

	@DataProvider(name = "input")
	public Object[][] getData() {
		return new Object[][] {
			{"p1", "p2"},
			{"m1", "m2"},
			{"r1", "r2"},
			{"d1", "d2"}
		};
	}
	
	@DataProvider(name = "excelp")
	public Object[][] readExcel() throws IOException {
		
		DataFormatter formater = new DataFormatter();
		
		FileInputStream arquivoExcel = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\MassaDeDados.xlsx");
		//System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\MassaDeDados.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(arquivoExcel); //abre a planilha
		XSSFSheet worksheet = workbook.getSheet("Sheet1"); //abre a sheet
		XSSFRow header = worksheet.getRow(0); 
		
		int rowNum = worksheet.getPhysicalNumberOfRows(); //pegar a ultima linha
		int colNum = header.getLastCellNum(); //pegar a ultima coluna
		
		Object data[][] = new Object[rowNum - 1][colNum];
		
		for(int i = 0; i <  rowNum -1; i++) {
			XSSFRow currentRow = worksheet.getRow(i + 1);
			
			for(int j = 0; j < colNum; j++) {
				if(currentRow == null) {
					data[i][j] = "";
				} else {
					XSSFCell cell = currentRow.getCell(j);
					
					if(cell == null) {
						data[i][j] = "";
					} else {
						String value = formater.formatCellValue(cell);
						data[i][j] = value;
					}
				}
			}
		}
		return data;
	}
	
	@DataProvider(name = "jfaker")
	public Object [][] getFakeData(){
		Faker predio = new Faker(new Locale("pt-BR"));
		
		return new Object[][] {
			{predio.name().firstName(), predio.food().fruit(), predio.harryPotter().character()},
			{predio.name().firstName(), predio.food().fruit(), predio.harryPotter().character()},
			{predio.name().firstName(), predio.food().fruit(), predio.harryPotter().character()},
			{predio.name().firstName(), predio.food().fruit(), predio.harryPotter().character()},
			{predio.name().firstName(), predio.food().fruit(), predio.harryPotter().character()}
		};
	}
	
	
}
