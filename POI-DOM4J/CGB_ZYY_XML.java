package com.trs.pep.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trs.pep.entity.ResourceClass;
import com.trs.web2frame.WCMServiceCaller1;
import com.trs.web2frame.dispatch.Dispatch;
import com.trs.web2frame.util.JsonHelper;

public class CGB_ZYY_XML {

	public static void main(String[] args) {
		List<ResourceClass> getWcmDatas = new ArrayList<ResourceClass>();
		// 3.向wcm推送数据
		String sServiceId2 = "wcm6_MetaDataCenter";
		String sMethodName2 = "saveMetaViewData";
		for (int j = 0; j < getWcmDatas.size(); j++) {
			// 构造传递参数
			Map<String, Object> bindMap = new HashMap<String, Object>();

			// 拼接推送需要的信息
			bindMap.put("ObjectId", new Integer(0)); // 0表示新增
			bindMap.put("ViewId", new Integer(27));
			System.out.println("444");

			// 调用WCMServiceCaller接口
			Dispatch oDispatch2 = WCMServiceCaller1.Call(sServiceId2, sMethodName2, bindMap, true);
			Map oJson = oDispatch2.getJson();
			String metaDataId = JsonHelper.getValueAsString(oJson, "METAVIEWDATA.METADATAID");
			System.out.println("推送后文档id:" + metaDataId);
			System.out.println("555");
		}
	}
}
