package br.com.progol.training.management.business.impl;

import org.springframework.stereotype.Service;

import br.com.progol.training.management.business.EmailSenderBusiness;
import br.com.progol.training.management.business.smtp.SMTPMailSender;
import br.com.progol.training.management.smtp.model.Email;

@Service
public class EmailSenderBusinessImpl implements EmailSenderBusiness {

	public String sendMail(Email email) {
		
		SMTPMailSender sender = new SMTPMailSender();
		
		sender.sendMessage(email.getTitle(), email.getMessage(), email.getTo());
		
		return "Email Enviado com Sucesso";
	}

}
