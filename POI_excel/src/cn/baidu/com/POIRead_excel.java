package cn.baidu.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIRead_excel {
	
	/**
	 *注意：
	 * // 1 判断文件后缀名是xls，还是xlsx
	 * // 2 如果是xls，使用HSSFWorkbook；如果是xlsx，使用XSSFWorkbook
	 */
	public static void testPOI(){
		
		try {
			//读取整个Excel文档
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\CGB\\Desktop\\Nginx和apache所在机器IP和启动命令.xlsx")));
			//读取第几个sheet页    索引从0开始
			XSSFSheet sheet = workbook.getSheetAt(0);  
			// 循环遍历整个sheet取出每一行 
			for (Row row : sheet) {
				               //取出每一行中的第几个  索引从0开始       取出值的类型
				String value = row.getCell(0).getStringCellValue();
				String value2 = row.getCell(1).getStringCellValue();
				String value3 = row.getCell(2).getStringCellValue();

				System.out.println(value+"--"+value2+"--"+value3+"--");
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		testPOI();
	}
	

}
