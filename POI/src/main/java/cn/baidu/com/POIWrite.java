package cn.baidu.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.baidu.utils.FileDownloadUtils;

public class POIWrite extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = "Excel导出.xls" ;
		//创建空的Excel
		HSSFWorkbook wb  = new HSSFWorkbook();
		//创建sheet页
		HSSFSheet sheet = wb.createSheet("POI导出");
		//创建第几行
		HSSFRow row = sheet.createRow(0);
		//创建单元格并赋值
		row.createCell(0).setCellValue("第一行第一列");
		row.createCell(1).setCellValue("第二行第二列");
		row.createCell(2).setCellValue("第三行第三列");
		row.createCell(3).setCellValue("第四行第四列");
		row.createCell(4).setCellValue("第五行第五列");
		row.createCell(5).setCellValue("第六行第六列");
		String mime = getServletContext().getMimeType(fileName);

		String filename = "数据导出.xls";
		try {
			//4.1获取浏览器类型
			String agent = req.getHeader("User-Agent");
			//两个头之一：content-type，告诉前台返回的数据类型
			String mimeType = getServletContext().getMimeType(filename);
			filename = FileDownloadUtils.encodeDownloadFilename(filename, agent);
			//一个流两个头
			//一个流：response的输出流
			ServletOutputStream os = resp.getOutputStream();
			resp.setContentType(mimeType);
			//两个头之二：content-disposition，告诉前台打开数据的方式
			resp.setHeader("content-disposition", "attachment;filename="+filename);
			//5.使用workbook的write方法将文件返回
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
