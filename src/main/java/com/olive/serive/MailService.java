package com.olive.serive;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired //Read new JavaMailSenderImpl() from container
	private JavaMailSender sender;
	
	public boolean sendEmail(
			String to,
			String cc[],
			String bcc[],
			String subject,
			String text,
			Resource file
			)
	{
		boolean isSent = false;
		try {
			//create new MimeMessage
			MimeMessage message =
					sender.createMimeMessage();
			MimeMessageHelper helper = new
					MimeMessageHelper(message, file!=null);
			helper.setTo(to);
			if(cc!=null)
				helper.setCc(cc);
			if(bcc!=null)
				helper.setBcc(bcc);
			helper.setSubject(subject);
			helper.setText(text);
			if(file!=null) {
				//file name, file data
				helper.addAttachment(file.getFilename(), file);
			}
		
			//send message
			sender.send(message);
			isSent=true;
			
		} catch (Exception e) {
			isSent=false;
			e.printStackTrace();
		}
		return isSent;
	}
}