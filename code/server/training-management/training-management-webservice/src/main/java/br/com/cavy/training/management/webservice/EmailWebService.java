package br.com.cavy.training.management.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.progol.training.management.business.EmailSenderBusiness;
import br.com.progol.training.management.smtp.model.Email;

@RestController
@RequestMapping("/email")
public class EmailWebService {

	@Autowired
	private EmailSenderBusiness emailSenderBusiness;

	@RequestMapping("/send")
	public String send(@RequestParam(value="cpf", required=true) Email email) {
		
		return emailSenderBusiness.sendMail(email);
	}
	
}
