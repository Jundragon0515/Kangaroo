package kh.spring.dao;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.stereotype.Component;
@Component
public class MailDAO {
	public String sendEmail(String to) {
		String host     = "smtp.naver.com";
		final String user   = "cwg94";
		final String password  = "1q2w3e4r%T";
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		System.out.println(to);
		String certi=this.randomWord();
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Assembly 인증번호");
			// Text
			message.setText("인증번호 : "+certi);
			Transport.send(message);
			return certi;
		} catch (MessagingException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String randomWord(){
		String result = "";
		while(true) {
			int rand1 = (int)(Math.random() * 3 + 1); // 1,2,3
			if(rand1==1) {//0~9
				int rand2 = (int)(Math.random() * 10 + 48);
				result += (char)rand2;
			}else if(rand1==2) { 
				int rand2 = (int)(Math.random() * 26 + 65);
				result += (char)rand2;
			}else {
				int rand2 = (int)(Math.random() * 26 + 97);
				result += (char)rand2;
			}
			if(result.length()==6) {
				break;
			}
		}
		return result;
	}
}