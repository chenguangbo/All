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
	// 应用网关固定的
	private static final String URL = "https://openapi.alipaydev.com/gateway.do";
	// 应用id
	private static final String APP_ID = "2016080700XXXX";
	// 私钥
	private static final String APP_PRIVATE_KEY = "xxxxxxxxxxxxxxxxxjtMYm0Gsrj2Zq8FQewN5eo";
	// 参数返回格式，只支持json
	private static final String FORMAT = "json";
	// 编码集
	private static final String CHARSET = "UTF-8";
	// 支付宝公钥，由支付宝生成
	private static final String ALIPAY_PUBLIC_KEY = "喜喜喜喜喜喜喜喜eaUHAw3PxYHLtxxxhBCa2rkSYOEhHqwxkmnsnETxAB";
	// 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	private static final String SIGN_TYPE = "RSA2";

	public void buyServlet() {

		AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
				ALIPAY_PUBLIC_KEY, SIGN_TYPE);

	}

	public static void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws ServletException, IOException {
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID,
				APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); // 获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
		alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"20150320010101001\","
				+ "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":88.88,"
				+ "    \"subject\":\"Iphone6 16G\"," + "    \"body\":\"Iphone6 16G\","
				+ "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
				+ "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\"" + "    }" + "  }");// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		httpResponse.setContentType("text/html;charset=" + CHARSET);
		httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}

	
	
}
