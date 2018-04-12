package com.trs.pep.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.jdbc.StringUtils;
import com.trs.web2frame.WCMServiceCaller1;
import com.trs.web2frame.dispatch.Dispatch;
import com.trs.web2frame.util.JsonHelper;

public class CGB_ZYY_POI {

	
	/* Excel 导入到 视图数据     会议*/
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		//XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(
		//		"C:\\Users\\Administrator.TRS-20140520WDQ\\Desktop\\中医药文献室_资料\\新建文件夹\\20180116馆藏图书题录-针灸.xls")));
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\Administrator.TRS-20140520WDQ\\Desktop\\中医药文献室_资料\\新建文件夹\\20180116馆藏图书题录-针灸.xls")));
		HashMap<String, Object> map = new HashMap<String, Object>();

		XSSFSheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			int rowNum = row.getRowNum();
			if (rowNum == 0 || row == null || row.getCell(0) == null) {
				continue;
			}

			int rowNum2 = row.getRowNum();
			// System.out.println(rowNum2);
			XSSFCell cell = null;
			short maxNum = row.getLastCellNum();
			// 取出每一行中的第几个 索引从0开始 取出值的类型
			/*
			 * String value = row.getCell(0).getStringCellValue(); String value2
			 * = row.getCell(1).getStringCellValue(); String value3 =
			 * row.getCell(2).getStringCellValue();
			 */
			double value1 = row.getCell(0).getNumericCellValue();
			String value2 = row.getCell(1).getStringCellValue();
			String value3 = row.getCell(2).getStringCellValue();
			String value4 = row.getCell(3).getStringCellValue();
			String value5 = row.getCell(4).getStringCellValue();
			String value6 = row.getCell(5).getStringCellValue();
			String value7 = row.getCell(6).getStringCellValue();
			String value8 = row.getCell(7).getStringCellValue();
			String value9 = row.getCell(8).getStringCellValue();
			System.out.println(value1 + "---" + value2 + "---" + value3 + "---" + value4 + "---" + value5 + "---"
					+ value6 + "---" + value7 + "---" + value8 + "---" + value9);
			Date stringToDate = null;
			String dateToString2 = null;
			System.err.println("==============>"+value6);
			if (value6.indexOf(".") != -1 && !value6.isEmpty() ) {
				stringToDate = DataUtils.stringToDate9(value6); //yyyy
				dateToString2 = DataUtils.dateToString2(stringToDate);
			} else if(value6.indexOf(".") == -1 && !value6.isEmpty()) {
				stringToDate = DataUtils.stringToDate10(value6);//yyyy.MM
				dateToString2 = DataUtils.dateToString2(stringToDate);
			}

			map.put("ObjectId", new Integer(0)); // 0表示新增
			map.put("biblioid", value2);
			map.put("title", value3);
			map.put("author", value4);
			map.put("publishername", value5);
			map.put("gysj", dateToString2);
			map.put("bc", value7);
			map.put("barcode", value8);
			map.put("volume", value9);
			Integer channelId = new Integer(108);
			map.put("channelId", channelId);
			System.out.println(map);
			String sServiceId2 = "wcm6_MetaDataCenter";
			String sMethodName2 = "saveMetaViewData";

			Dispatch oDispatch2 = WCMServiceCaller1.Call(sServiceId2, sMethodName2, map, true);
			// System.out.println(oDispatch2);
			Map oJson = oDispatch2.getJson();
			//System.err.println(oJson);
			String metaDataId = JsonHelper.getValueAsString(oJson, "METAVIEWDATA.METADATAID");
			System.out.println("推送后文档id:" + metaDataId);
			System.out.println("==================一个XML==================");

		}
	}

}
