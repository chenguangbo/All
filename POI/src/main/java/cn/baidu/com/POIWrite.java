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
import org.apache.poi.ss.util.CellRangeAddress;
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
		//创建第二行
		Row row2 = sheet.createRow(1);

		
		//设置每一列宽度     都是256的倍数                             第一个参数是第几列             第二个参数是宽度   
		sheet.setColumnWidth(0,25 * 256);  
		sheet.setColumnWidth(5,25 * 256);
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
        //设置背景颜色    设置单元格样式时必须加上这句   否则没有效果    FIll:充满      pattern:样式  
        //设置填充样式
        hlinkstyle.setFillPattern(HSSFCellStyle.ALIGN_CENTER);
        //设置背景色
        hlinkstyle.setFillBackgroundColor(HSSFColor.AQUA.index);
        hlinkstyle.setFillForegroundColor(HSSFColor.RED.index);
        hlinkstyle.setFillBackgroundColor(HSSFColor.LIGHT_BLUE.index);
        //给样式附上字体样式
        hlinkstyle.setFont(hlinkfont);  

        //创建  超链接帮助类
        CreationHelper createHelper = wb.getCreationHelper();
        //设置链接
		HSSFHyperlink hyperLink = (HSSFHyperlink) createHelper.createHyperlink(Hyperlink.LINK_URL);
		hyperLink.setAddress("http://www.yiibai.com"); 
		//给这一行附上链接
		cell.setHyperlink(hyperLink);
		//给这一行附上样式
		cell.setCellStyle(hlinkstyle); 
		cell.setCellValue("第六行第六列");
		//合并单元格
		CellRangeAddress cra=new CellRangeAddress(2, 4, 4, 7); // 起始行, 终止行, 起始列, 终止列     (包左包右,从0开始)
		 //在sheet里增加合并单元格  
        sheet.addMergedRegion(cra);  
        //创建一行                 第三行
        Row row3 = sheet.createRow(3);  
        //创建这一行的第3行的   第3列
        Cell cell_1 = row3.createCell(3);  
        //设置第三行第三列的数据
        cell_1.setCellValue("When you're right , no one remembers, when you're wrong ,no one forgets .");  
          
        //cell 位置3-9被合并成一个单元格，不管你怎样创建第4个cell还是第5个cell…然后在写数据。都是无法写入的。  
        //创建第三行的地10列
        Cell cell_2 = row.createCell(10);  
        //设置数据
        cell_2.setCellValue("what's up ! ");  
          
		
		
		
		
		
		
		
		
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
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
