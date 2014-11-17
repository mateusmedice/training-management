package br.com.progol.training.management.business;

import br.com.progol.training.management.smtp.model.Email;

public interface EmailSenderBusiness {

	String sendMail(Email email);
	
}
