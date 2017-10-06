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

	// Ӧ�����ع̶���                       ɳ������ʽ�治ͬ
	private static final String URL = "https://openapi.alipaydev.com/gateway.do";
	// Ӧ��id
	private static final String APP_ID = "20160807";
	// ˽Կ
	private static final String APP_PRIVATE_KEY = "";
	// �������ظ�ʽ��ֻ֧��json
	private static final String FORMAT = "json";
	// ���뼯
	private static final String CHARSET = "UTF-8";
	// ֧������Կ����֧��������
	private static final String ALIPAY_PUBLIC_KEY = "";
	// �̻�����ǩ���ַ�����ʹ�õ�ǩ���㷨���ͣ�Ŀǰ֧��RSA2��RSA���Ƽ�ʹ��RSA2
	private static final String SIGN_TYPE = "RSA2";

	public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws ServletException, IOException {
		AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
				ALIPAY_PUBLIC_KEY, SIGN_TYPE); // ��ó�ʼ����AlipayClient
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// ����API��Ӧ��request
		alipayRequest.setReturnUrl("http://localhost:8080/Alipay/pay.html");
		alipayRequest.setNotifyUrl("http://localhost:8080/Alipay/pay.html");// �ڹ������������û�����֪ͨ��ַ
		//����ǰ̨���ݵĲ���
		String out_trade_no = (String) httpRequest.getParameter("out_trade_no_test");// �������
		String total_amount = (String) httpRequest.getParameter("total_amount");// �ܽ��
		String product_code = "FAST_INSTANT_TRADE_PAY";// ���۲�Ʒ�룬�̼Һ�֧����ǩԼ�Ĳ�Ʒ�룬Ϊ�̶�ֵQUICK_MSECURITY_PAY     ����ɳ���ı�����FAST_INSTANT_TRADE_PAY
		String subject = "���ǳ���";// ��Ʒ����
		String body = "���涷��";// ��Ʒ��ϸ
		String passback_params = URLEncoder.encode("�����������˲����", "UTF-8");// passback_params���ûش��������������ʱ�����˸ò������򷵻ظ��̻�ʱ��ش��ò�����֧���������첽֪ͨʱ���ò���ԭ�����ء��������������UrlEncode֮��ſ��Է��͸�֧����
		String sys_service_provider_id = "XXXXXXXXXXXXX"; // �̼�id
		//ƴװ����                                                                  
		StringBuffer sb = new StringBuffer("{");
		sb.append("\"out_trade_no\":").append("\""+out_trade_no+"\"").append(",");
		sb.append("\"product_code\":").append("\""+product_code+"\"").append(",");
		sb.append("\"total_amount\":").append(total_amount).append(",");
		sb.append("\"subject\":").append("\""+subject+"\"").append(",");
		sb.append("\"body\":").append("\""+body+"\"").append(",");
		sb.append("\"passback_params\":").append("\""+passback_params+"\"").append(",");
		sb.append("\"extend_params\":{"); //ҵ����չ����
		sb.append("  \"sys_service_provider_id\":").append("\""+sys_service_provider_id+"\"").append("  }").append(" }");
		System.err.println(sb.toString());
		//��ƴװ�Ĳ����ŵ�alipayRequest��
		alipayRequest.setBizContent(sb.toString());
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // ����SDK���ɱ�
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		httpResponse.setContentType("text/html;charset=" + CHARSET);
		httpResponse.getWriter().write(form);// ֱ�ӽ������ı�html�����ҳ��
		System.out.println(form);
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
