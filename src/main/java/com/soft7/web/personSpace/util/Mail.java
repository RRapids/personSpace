package com.soft7.web.personSpace.util;

import com.soft7.web.personSpace.entity.User;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**\
 * 
 * 使用JavaMail发送邮件
 *
 */
public class Mail {
	public Mail(User user) {
		try {
			// 获得属性，并生成Session对象
			Properties props = new Properties();
			Transport transport;
			Session sendsession;
			sendsession = Session.getInstance(props, null);
			// 向属性中写入SMTP服务器的地址
			props.put("mail.smtp.host", "smtp.qq.com");
			// 设置SMTP服务器需要权限认证
			props.put("mail.smtp.auth", "true");
			//MyAuthenticator myauth = new MyAuthenticator("workniit@163.com", "99081035c");
			// 设置输出调试信息
			sendsession.setDebug(true);
			// 根据Session生成Message对象
			Message message = new MimeMessage(sendsession);
			//  设置发信人地址
			message.setFrom(new InternetAddress("rapids7987@qq.com"));
			// 设置收信人地址
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
			// 设置e-mail标题
			message.setSubject("您好！感谢您注册！");
			// 设置e-mail发送时间
			message.setSentDate(new Date());
			// 设置e-mail内容
			message.setContent(user.getUsername()+"：请经常访问本网站！" +
					"<br><a href='http://localhost:8080/MessageBoard/email?id="+user.getId()+"&active="+user.getActive()+"'>请点击激活帐号</a>", "text/html;charset=UTF-8");
			// 保存对于Email.的修改
			message.saveChanges();
			// 根据Session生成Transport对象
			transport = sendsession.getTransport("smtp");
			// 连接到SMTP服务器
			transport.connect("smtp.qq.com", "rapids7987", "hzetenllloevbbag");
			// 发送e-mail
			transport.sendMessage(message, message.getAllRecipients());
			// 关闭Transport连接
			transport.close();

		} catch (MessagingException me) {
			me.printStackTrace();
		}

	}

}
