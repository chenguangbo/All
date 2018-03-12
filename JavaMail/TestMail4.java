package cn.trs.com;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class TestMail4 {

	public static void main(String[] args) {
		// 发送email
		HtmlEmail email = new HtmlEmail();
		try {
			// 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
			email.setHostName("smtp.163.com");
			// 字符编码集的设置
			email.setCharset("UTF-8");
			// 收件人的邮箱
			email.addTo("cgb2499404424@163.com");
			// 发送人的邮箱
			email.setFrom("cgb2499404424@163.com", "系统消息");
			// 安全验证
			email.setSSL(true);

			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
			Authenticator authenticator = new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					// 发送邮件的@符号前面的 授权码
					return new PasswordAuthentication("cgb2499404424", "qq1234");
				}
			};
			/* 身份认证 */
			email.setAuthenticator(authenticator);
			// 要发送的邮件主题
			email.setSubject("邮件主题");
			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签

			/* 设置包含附件的消息 */
			email.setMsg("MyEmail.eml");
			// 设置文本类型的消息
			email.setTextMsg("我们都是好孩子！");
			// 是否开启debug调试
			email.setDebug(false);
			// 发送
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		} finally {

		}
		System.out.println("邮件发送完毕！");
	}

}
