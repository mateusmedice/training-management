package br.com.cavy.training.management.business;

import br.com.cavy.training.management.smtp.model.Email;

public interface EmailSenderBusiness {

	String sendMail(Email email);
	
}
