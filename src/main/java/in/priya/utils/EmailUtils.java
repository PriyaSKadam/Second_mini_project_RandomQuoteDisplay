package in.priya.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String subject,String body,String to)
	{
		MimeMessage mimeMessage=mailSender.createMimeMessage();
		
		MimeMessageHelper msgHelper= new MimeMessageHelper(mimeMessage);
		
		try {
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.setText(body);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	    mailSender.send(mimeMessage);
	    
		return true;
	}

}
