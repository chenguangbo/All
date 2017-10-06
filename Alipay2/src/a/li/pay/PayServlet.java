package a.li.pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

public class PayServlet {
	// Ӧ�����ع̶���
	private static final String URL = "https://openapi.alipaydev.com/gateway.do";
	// Ӧ��id
	private static final String APP_ID = "2016080700XXXX";
	// ˽Կ
	private static final String APP_PRIVATE_KEY = "xxxxxxxxxxxxxxxxxjtMYm0Gsrj2Zq8FQewN5eo";
	// �������ظ�ʽ��ֻ֧��json
	private static final String FORMAT = "json";
	// ���뼯
	private static final String CHARSET = "UTF-8";
	// ֧������Կ����֧��������
	private static final String ALIPAY_PUBLIC_KEY = "ϲϲϲϲϲϲϲϲeaUHAw3PxYHLtxxxhBCa2rkSYOEhHqwxkmnsnETxAB";
	// �̻�����ǩ���ַ�����ʹ�õ�ǩ���㷨���ͣ�Ŀǰ֧��RSA2��RSA���Ƽ�ʹ��RSA2
	private static final String SIGN_TYPE = "RSA2";

	public void buyServlet() {

		AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
				ALIPAY_PUBLIC_KEY, SIGN_TYPE);

	}

	public static void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws ServletException, IOException {
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID,
				APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); // ��ó�ʼ����AlipayClient
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// ����API��Ӧ��request
		alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
		alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");// �ڹ������������û�����֪ͨ��ַ
		alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"20150320010101001\","
				+ "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":88.88,"
				+ "    \"subject\":\"Iphone6 16G\"," + "    \"body\":\"Iphone6 16G\","
				+ "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
				+ "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\"" + "    }" + "  }");// ���ҵ�����
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // ����SDK���ɱ�
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		httpResponse.setContentType("text/html;charset=" + CHARSET);
		httpResponse.getWriter().write(form);// ֱ�ӽ������ı�html�����ҳ��
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}

	
	
}
