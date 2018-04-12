package com.trs.pep.test;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mysql.jdbc.StringUtils;
import com.trs.web2frame.WCMServiceCaller1;
import com.trs.web2frame.dispatch.Dispatch;
import com.trs.web2frame.util.JsonHelper;

/**
 * 民国图书
 * 
 * @author Administrator
 */
public class CGB_ZYY_DOM4J {

	public static void main(String[] args) throws Exception {
//		sendToWCM();
		
		
		String filepath = "C:\\Users\\Administrator.TRS-20140520WDQ\\Desktop\\中医药文献室_资料\\新建文件夹\\民国图书\\";
		File file = new File(filepath);
		String[] list = file.list();
		for (String string : list) {
			File file2 = new File(file.getAbsolutePath()+"\\"+string);
			if(file2.isDirectory()){
				continue ;
			}
			String fileName = file.getAbsolutePath()+"\\"+string;
			System.out.println("fileName: ---> "+fileName);
			sendToWCM(fileName);
			System.out.println(fileName);
		}
		
		
	}

	public static void sendToWCM(String filename) throws Exception {
		
		String sServiceId2 = "wcm6_MetaDataCenter";
		String sMethodName2 = "saveMetaViewData";
		Integer channelId = new Integer(78);
		
		
		File file = new File(filename);
		HashMap<String, Object> map = new HashMap<String, Object>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element element = document.getRootElement();

		String title = element.element("title").getText();// 图书名称

		List<Element> list = element.element("info").elements("biblioid");
		String biblioid = null;
		for (Element element2 : list) {
			if (element2.attributeValue("class").equals("索书号")) {
				biblioid = element.element("info").element("biblioid").getText();// 索书号
				//System.out.println(biblioid);
			}
		}
		String author = element.element("info").element("authorgroup").getText(); // 责任者
		//System.out.println(author);
		// 出版者 publishername
		String publishername = element.element("info").element("publisher").element("publishername").getText();
		//System.out.println(publishername);
		// 出版地址
		String address = element.element("info").element("publisher").element("address").getText();
		//System.out.println(address);

		List<Element> elements2 = element.element("info").elements("pubdate");
		String ckmgDate = null, cbmgDate = null;
		Date  cbgyDate = null;
		String ckgyDate = null;
		for (Element element2 : elements2) {
			if (element2.attributeValue("role").equals("初版民国时间")) {
				ckmgDate = element2.getText();
				System.out.println(element2.getText());
			}
			if (element2.attributeValue("role").equals("初版公元时间")) {
				if (StringUtils.isNullOrEmpty(element2.getText())) {
					continue;
				}
				String date2 = element2.getText();
				if (date2.lastIndexOf("正") != -1) {
					System.out.println("包含正月");
					continue;
				}
				if (date2.lastIndexOf("日") != -1 && date2.lastIndexOf("月") != -1) {
					int lastIndexOf = date2.lastIndexOf("日");
					Date date = DataUtils.stringToDate5(date2.substring(0, lastIndexOf + 1));
					
					ckgyDate = DataUtils.dateToString2(date);
					System.out.println(ckgyDate);
				} else if (date2.lastIndexOf("日") != -1) {
					int lastIndexOf = date2.lastIndexOf("日");
					Date date = DataUtils.stringToDate8(date2.substring(0, lastIndexOf + 1));
					ckgyDate = DataUtils.dateToString2(date);;
					System.out.println(ckgyDate);
				} else if (date2.lastIndexOf("月") != -1) {
					int lastIndexOf = date2.lastIndexOf("月");
					Date date = DataUtils.stringToDate4(date2.substring(0, lastIndexOf + 1));
					ckgyDate = DataUtils.dateToString2(date);;
					System.out.println(ckgyDate);
				} else if (date2.lastIndexOf("年") != -1) {
					Date date = DataUtils.stringToDate6(element2.getText());
					ckgyDate = DataUtils.dateToString2(date);;
					System.out.println(element2.getText());
				} else if (date2.lastIndexOf("/") != -1) {
					Date date = DataUtils.stringToDate7(element2.getText());
					ckgyDate = DataUtils.dateToString2(date);;
					System.out.println(element2.getText());
				} else {
					System.out.println("不在范围内的：<----->");
				}
			}
			if (element2.attributeValue("role").equals("再版民国时间")) {
				cbmgDate = element2.getText();
				System.out.println(element2.getText());
			}
			if (element2.attributeValue("role").equals("再版公元时间")) {
				// Date date = DataUtils.stringToDate4(element2.getText());
				// cbgyDate = date;
				// System.out.println(element2.getText());

				if (StringUtils.isNullOrEmpty(element2.getText())) {
					continue;
				}
				String date2 = element2.getText();

				if (date2.lastIndexOf("日") != -1) {
					int lastIndexOf = date2.lastIndexOf("日");
					Date date = DataUtils.stringToDate5(date2.substring(0, lastIndexOf + 1));
					cbgyDate = date;
					System.out.println(cbgyDate);
				} else if (date2.lastIndexOf("月") != -1) {
					int lastIndexOf = date2.lastIndexOf("月");
					Date date = DataUtils.stringToDate4(date2.substring(0, lastIndexOf + 1));
					cbgyDate = date;
					System.out.println(cbgyDate);
				} else if (date2.lastIndexOf("年") != -1) {
					Date date = DataUtils.stringToDate6(element2.getText());
					cbgyDate = date;
					System.out.println(element2.getText());
				} else if (date2.lastIndexOf("/") != -1) {
					Date date = DataUtils.stringToDate7(element2.getText());
					cbgyDate = date;
					System.out.println(element2.getText());
				} else {
					System.out.println("不在范围内的：--===》");
				}
			}
			
			map.put("CHANNELID",channelId); // 栏目id
			map.put("ObjectId", new Integer(0)); // 0表示新增
			
			map.put("title", title);
			map.put("biblioid", biblioid);
			map.put("author", author);
			map.put("publishername", publishername);
			map.put("address", address);
			map.put("ckmgDate", ckmgDate);
		//	map.put("cbmgDate", cbmgDate);
			map.put("mgsj", ckgyDate);
		//	map.put("ckgyDate", ckgyDate);
			map.put("gysj",  ckgyDate);
			
			//ckgyDate 		cbgyDate
			// mgsj  gysj
			
			
			System.out.println("出版公元时间："+ckgyDate);
			System.out.println(map);
			Dispatch oDispatch2 = WCMServiceCaller1.Call(sServiceId2, sMethodName2, map, true);
			System.out.println(oDispatch2);
			Map oJson = oDispatch2.getJson();
			String metaDataId = JsonHelper.getValueAsString(oJson, "METAVIEWDATA.METADATAID");
			System.out.println("推送后文档id:" + metaDataId);
			System.out.println("==================一个XML==================");
			
			
		}

	}

}
