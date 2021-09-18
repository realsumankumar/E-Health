package com.example.emailservice.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.example.emailservice.dto.MailRequest;
import com.example.emailservice.dto.MailResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender; 
	
	@Autowired
	private Configuration config;
	
	
	public MailResponse	sendEmail(MailRequest request, Map<String, Object> model) {
		
		MailResponse response = new MailResponse();
		MimeMessage message =  sender.createMimeMessage();
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			
			Template t =  config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			
			helper.setTo(request.getPatientEmail());
			helper.setText(html,true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);
			
			response.setMessage("mail send to : " + request.getPatientEmail());
			response.setStatus(Boolean.TRUE);
		} catch(MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Send Failure :" + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		
		return response;
	}

}
