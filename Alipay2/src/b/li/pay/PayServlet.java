package b.li.pay;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

public class PayServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 应用网关固定的                       沙箱版和正式版不同
	private static final String URL = "https://openapi.alipaydev.com/gateway.do";
	// 应用id
	private static final String APP_ID = "20160807";
	// 私钥
	private static final String APP_PRIVATE_KEY = "";
	// 参数返回格式，只支持json
	private static final String FORMAT = "json";
	// 编码集
	private static final String CHARSET = "UTF-8";
	// 支付宝公钥，由支付宝生成
	private static final String ALIPAY_PUBLIC_KEY = "";
	// 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	private static final String SIGN_TYPE = "RSA2";

	public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws ServletException, IOException {
		AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
				ALIPAY_PUBLIC_KEY, SIGN_TYPE); // 获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl("http://localhost:8080/Alipay/pay.html");
		alipayRequest.setNotifyUrl("http://localhost:8080/Alipay/pay.html");// 在公共参数中设置回跳和通知地址
		//接收前台传递的参数
		String out_trade_no = (String) httpRequest.getParameter("out_trade_no_test");// 订单编号
		String total_amount = (String) httpRequest.getParameter("total_amount");// 总金额
		String product_code = "FAST_INSTANT_TRADE_PAY";// 销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY     但是沙箱版的必须是FAST_INSTANT_TRADE_PAY
		String subject = "我是超人";// 商品名称
		String body = "神奇斗篷";// 商品详细
		String passback_params = URLEncoder.encode("嘻嘻哈哈超人不会飞", "UTF-8");// passback_params公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝
		String sys_service_provider_id = "XXXXXXXXXXXXX"; // 商家id
		//拼装参数                                                                  
		StringBuffer sb = new StringBuffer("{");
		sb.append("\"out_trade_no\":").append("\""+out_trade_no+"\"").append(",");
		sb.append("\"product_code\":").append("\""+product_code+"\"").append(",");
		sb.append("\"total_amount\":").append(total_amount).append(",");
		sb.append("\"subject\":").append("\""+subject+"\"").append(",");
		sb.append("\"body\":").append("\""+body+"\"").append(",");
		sb.append("\"passback_params\":").append("\""+passback_params+"\"").append(",");
		sb.append("\"extend_params\":{"); //业务扩展参数
		sb.append("  \"sys_service_provider_id\":").append("\""+sys_service_provider_id+"\"").append("  }").append(" }");
		System.err.println(sb.toString());
		//将拼装的参数放到alipayRequest中
		alipayRequest.setBizContent(sb.toString());
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		httpResponse.setContentType("text/html;charset=" + CHARSET);
		httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
		System.out.println(form);
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
