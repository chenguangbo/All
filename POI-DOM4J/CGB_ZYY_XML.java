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
		// 3.��wcm��������
		String sServiceId2 = "wcm6_MetaDataCenter";
		String sMethodName2 = "saveMetaViewData";
		for (int j = 0; j < getWcmDatas.size(); j++) {
			// ���촫�ݲ���
			Map<String, Object> bindMap = new HashMap<String, Object>();

			// ƴ��������Ҫ����Ϣ
			bindMap.put("ObjectId", new Integer(0)); // 0��ʾ����
			bindMap.put("ViewId", new Integer(27));
			System.out.println("444");

			// ����WCMServiceCaller�ӿ�
			Dispatch oDispatch2 = WCMServiceCaller1.Call(sServiceId2, sMethodName2, bindMap, true);
			Map oJson = oDispatch2.getJson();
			String metaDataId = JsonHelper.getValueAsString(oJson, "METAVIEWDATA.METADATAID");
			System.out.println("���ͺ��ĵ�id:" + metaDataId);
			System.out.println("555");
		}
	}
}
