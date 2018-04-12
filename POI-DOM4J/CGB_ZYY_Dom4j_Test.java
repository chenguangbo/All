package com.trs.pep.test;

import java.io.File;
import java.util.Calendar;
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

public class CGB_ZYY_Dom4j_Test {

	/**
	 * wcmmetatablewxzl
	 * 
	 * @param arg
	 * @throws Exception
	 */

	
	/* 民国期刊 */
	public static void main(String[] arg) throws Exception {

		//String str = "C:\\Users\\Administrator.TRS-20140520WDQ\\Desktop\\中医药文献室_资料\\新建文件夹\\民国期刊\\廣濟医刊第十卷第三期.xml";
		//sendToViewDate(str);
		
		
		String filepath = "C:\\Users\\Administrator.TRS-20140520WDQ\\Desktop\\中医药文献室_资料\\新建文件夹\\民国期刊\\";
		File file = new File(filepath);
		String[] list = file.list();
		for (String string : list) {
			File file2 = new File(file.getAbsolutePath()+"\\"+string);
			if(file2.isDirectory()){
				continue ;
			}
			String fileName = file.getAbsolutePath()+"\\"+string;
			System.out.println("fileName: ---> "+fileName);
			sendToViewDate(fileName);
		}
		
		
	}
	
	
	
	public static void sendToViewDate(String str) throws Exception{
		String sServiceId2 = "wcm6_MetaDataCenter";
		String sMethodName2 = "saveMetaViewData";
		
		Integer channelId = new Integer(79);
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(str));
		HashMap<String, Object> map = new HashMap<String, Object>();
		Element element = doc.getRootElement();
		String title = element.element("title").getText();// 期刊名称
		String issuenum = element.element("info").element("issuenum").getStringValue();// 卷
		String volumenum = element.element("info").element("volumenum").getStringValue();// 期
		String period = element.element("info").element("period").getStringValue();// 月刊类型
		String publishername = element.element("info").element("publisher").element("publishername").getText();// 出版者

		String address = null;
		if (element.element("info").element("publisher").element("publishername").element("address") != null
				&& element.element("info").element("publisher").element("publishername").element("address")
						.element("street") != null) {
			address = element.element("info").element("publisher").element("publishername").element("address")
					.element("street").getStringValue();// 出版地址
		} else {
			System.out.println("出版地址为空:<--->"+str);
		}

		List<Element> elements2 = element.element("info").elements("pubdate");
		String ckmgDate = null, cbmgDate = null;
		String ckgyDate = null;
		String cbgyDate = null;
		for (Element element2 : elements2) {
			if (element2.attributeValue("role").equals("创刊民国时间")) {
				ckmgDate = element2.getText();
				System.out.println(element2.getText());
			}
			if (element2.attributeValue("role").equals("创刊公元时间")) {
				if(StringUtils.isNullOrEmpty(element2.getText())){
					continue ;
				}
				String date2 = element2.getText();
				if(date2.lastIndexOf("正")!=-1){
					System.out.println("包含正月"+str);
					continue ;
				}
				if(date2.lastIndexOf("日")!=-1 && date2.lastIndexOf("月")!=-1){
					int lastIndexOf = date2.lastIndexOf("日");
					Date date = DataUtils.stringToDate5(date2.substring(0, lastIndexOf+1));
					ckgyDate = DataUtils.dateToString2(date);
				}else if(date2.lastIndexOf("日")!=-1){
					int lastIndexOf = date2.lastIndexOf("日");
					Date date = DataUtils.stringToDate8(date2.substring(0, lastIndexOf+1));
					ckgyDate = DataUtils.dateToString2(date);
				}else if(date2.lastIndexOf("月")!=-1){
					int lastIndexOf = date2.lastIndexOf("月");
					Date date = DataUtils.stringToDate4(date2.substring(0, lastIndexOf+1));
					ckgyDate = DataUtils.dateToString2(date);
				}else if(date2.lastIndexOf("年")!=-1){
					Date date = DataUtils.stringToDate6(element2.getText());
					ckgyDate = DataUtils.dateToString2(date);
					System.out.println(element2.getText());
				} else if(date2.lastIndexOf("/")!=-1){
					Date date = DataUtils.stringToDate7(element2.getText());
					ckgyDate = DataUtils.dateToString2(date);
					System.out.println(element2.getText());
				}else {
					System.out.println("不在范围内的：<----->"+str);
				}
			}
			if (element2.attributeValue("role").equals("出版民国时间")) {
				cbmgDate = element2.getText();
				System.out.println(element2.getText());
			}
			if (element2.attributeValue("role").equals("出版公元时间")) {
//				if(StringUtils.isNullOrEmpty(element2.getText())){
//					continue ;
//				}
				String date2 = element2.getText();
				
				if(date2.lastIndexOf("日")!=-1){
					int lastIndexOf = date2.lastIndexOf("日");
					Date date = DataUtils.stringToDate5(date2.substring(0, lastIndexOf+1));
					cbgyDate = DataUtils.dateToString2(date);
				}else if(date2.lastIndexOf("月")!=-1){
					int lastIndexOf = date2.lastIndexOf("月");
					Date date = DataUtils.stringToDate4(date2.substring(0, lastIndexOf+1));
					cbgyDate = DataUtils.dateToString2(date);
				}else if(date2.lastIndexOf("年")!=-1){
					Date date = DataUtils.stringToDate6(element2.getText());
					cbgyDate = DataUtils.dateToString2(date);
					System.out.println(element2.getText());
				}else if(date2.lastIndexOf("/")!=-1){
					Date date = DataUtils.stringToDate7(element2.getText());
					
					cbgyDate = DataUtils.dateToString2(date);
					System.out.println(element2.getText());
				}else {
					System.out.println("不在范围内的：--===》"+str);
				}
			}
		}

		String biblioid = null;
		List<Element> elements3 = element.element("info").elements("biblioid");
		for (Element element3 : elements3) {
			if (element3.attributeValue("class").equals("索书号")) {
				System.out.println(element3.getText());
				biblioid = element3.getText();
			}
		}
//System.err.println(ckgyDate);
		map.put("title", title); // 期刊名称
		map.put("channelId",channelId); // 栏目id
		map.put("ObjectId", new Integer(0)); // 0表示新增
		map.put("issuenum", issuenum); // 期
		map.put("volumenum", volumenum); // 卷
		map.put("period", period); // 月刊类型
		map.put("publishername", publishername); // 出版者
		map.put("address", address); // 出版地址
		map.put("ckmgDate", ckmgDate); // 创刊民国时间
		map.put("mgsj", ckgyDate); // 创刊公元时间
		map.put("cbmgDate", cbmgDate); // 出版民国时间
		map.put("gysj", cbgyDate); // 出版公元时间
		map.put("biblioid", biblioid); // 出版公元时间
		
		//ckgyDate 		cbgyDate
		// mgsj  gysj
		System.err.println(map);
		Dispatch oDispatch2 = WCMServiceCaller1.Call(sServiceId2, sMethodName2, map, true);
	//	System.out.println(oDispatch2);
		Map oJson = oDispatch2.getJson();
		System.err.println(oJson);
		String metaDataId = JsonHelper.getValueAsString(oJson, "METAVIEWDATA.METADATAID");
		System.out.println("推送后文档id:" + metaDataId);
		System.out.println("==================一个XML==================");

	}
	
	
}
