package cn.trs.test.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class POIRead_excel {
	
	private static Workbook workbook;

	/**
	 *注意：
	 * // 1 判断文件后缀名是xls，还是xlsx
	 * // 2 如果是xls，使用HSSFWorkbook；如果是xlsx，使用XSSFWorkbook
	 * 		Excel2003版本只能存储65536行、256列数据
  	 *		Excel2007及以上版本能存储1048576行、16384列数据
	 *
	 */
	public static void testPOI(){
		File file = new File("C:\\Users\\CGB\\Desktop\\Nginx和apache所在机器IP和启动命令.xlsx");
		try {
			
			if(!file.toURI().toString().isEmpty() && file.toURI().toString()!=null && file.toURI().toString().endsWith("xlsx")){
				//2007版级以后的Excel
				workbook = new XSSFWorkbook(new FileInputStream(file));
			}else if(!file.toURI().toString().isEmpty() && file.toURI().toString()!=null && file.toURI().toString().endsWith("xls")){
				//2003版Excel
				workbook = new HSSFWorkbook(new FileInputStream(file));
			}else{
				System.out.println("传入的文件格式不正确！请重新上传！;)");
				return ;
			}
			//读取第几个sheet页    索引从0开始
			Sheet sheet = workbook.getSheetAt(0);  
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
