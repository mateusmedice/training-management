package br.com.progol.training.management.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.progol.training.management.business.UserBusiness;
import br.com.progol.training.management.model.User;
import br.com.progol.training.management.webservice.util.WebServiceUtil;

@RestController
@RequestMapping("/user")
public class UserWebService extends WebServiceUtil {
	
	@Autowired
	private UserBusiness userBusiness;

	@RequestMapping("/findByCpf")
	public String find(@RequestParam(value="cpf", required=true) String cpf) {
		
		User user = userBusiness.findUserByCPF(cpf);
		
		return toJson(user);
	}
	
	@RequestMapping("/newTraining")
	public String newTrainig(@RequestParam(value="cpf", required=true) String cpf) {
		
		return toJson("");
	}

}
