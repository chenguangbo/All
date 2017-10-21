package cn.baidu.com;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;

import cn.baidu.utils.FileDownloadUtils;

public class POIWrite extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileName = "Excel导出.xls";
		// 创建空的Excel
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建sheet页
		HSSFSheet sheet = wb.createSheet("POI导出");
		// 创建第几行
		Row row = sheet.createRow(0);
		Row row2 = sheet.createRow(1);
		// 设置行高
		row.setHeight((short) 500);
		// 创建单元格并赋值
		row.createCell(0).setCellValue("第一行第一列");
		row.createCell(1).setCellValue("第二行第二列");
		row.createCell(2).setCellValue("第三行第三列");
		row.createCell(3).setCellValue("第四行第四列");
		row.createCell(4).setCellValue("第五行第五列");
		Cell cell = row.createCell(5);
		row2.createCell(5).setCellValue("第五行第五列");
		//创建样式对象
		HSSFCellStyle hlinkstyle = wb.createCellStyle();
		//创建字体样式对象
		HSSFFont hlinkfont = wb.createFont();
		//设置字体下划线
        hlinkfont.setUnderline(HSSFFont.U_SINGLE);  
        //设置字体为红色
        hlinkfont.setColor(HSSFColor.RED.index);
        //设置单元格的中的内容在      本单元格中的样式
        hlinkstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直    
        hlinkstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平    
        //设置背景颜色
        hlinkstyle.setFillBackgroundColor(HSSFColor.AQUA.index);
        
    //    hlinkstyle.setFillPattern(HSSFCellStyle.BIG_SPOTS);
    //    hlinkstyle.setFillForegroundColor(HSSFColor.RED.index);
    //    hlinkstyle.setFillBackgroundColor(HSSFColor.LIGHT_BLUE.index);
        
        hlinkstyle.setFillForegroundColor(HSSFColor.RED.index); 
        //给样式附上字体样式
        hlinkstyle.setFont(hlinkfont);  

        sheet.setColumnWidth((short)10,(short)20);    
        row.setHeight((short)50); 

        CreationHelper createHelper = wb.getCreationHelper();
        //设置链接
		HSSFHyperlink hyperLink = (HSSFHyperlink) createHelper.createHyperlink(Hyperlink.LINK_URL);
		hyperLink.setAddress("http://www.yiibai.com"); 
		//给这一行附上链接
		cell.setHyperlink(hyperLink);
		//给这一行附上样式
		cell.setCellStyle(hlinkstyle); 
		cell.setCellValue("第六行第六列");
		
		
		
		/*
		 * 导出部分
		 */
		String filename = "数据导出.xls";
		try {
			// 4.1获取浏览器类型
			String agent = req.getHeader("User-Agent");
			// 两个头之一：content-type，告诉前台返回的数据类型
			String mimeType = getServletContext().getMimeType(filename);
			filename = FileDownloadUtils.encodeDownloadFilename(filename, agent);
			// 一个流两个头
			// 一个流：response的输出流
			ServletOutputStream os = resp.getOutputStream();
			resp.setContentType(mimeType);
			// 两个头之二：content-disposition，告诉前台打开数据的方式
			resp.setHeader("content-disposition", "attachment;filename=" + filename);
			// 5.使用workbook的write方法将文件返回
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
