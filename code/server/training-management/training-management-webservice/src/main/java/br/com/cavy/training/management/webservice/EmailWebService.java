package br.com.cavy.training.management.webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cavy.training.management.business.EmailSenderBusiness;
import br.com.cavy.training.management.smtp.model.Email;

@Path("/email")
public class EmailWebService {

	@Autowired
	private EmailSenderBusiness emailSenderBusiness;

	@POST
	@Path("/send")
	public void send(Email email) {
		
		this.emailSenderBusiness.sendMail(email);
	}
	
}
