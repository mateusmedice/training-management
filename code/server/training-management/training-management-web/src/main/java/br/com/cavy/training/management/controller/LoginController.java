package br.com.cavy.training.management.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.cavy.training.management.util.PropertiesUtil;
import br.com.progol.training.management.business.AthleteBusiness;
import br.com.progol.training.management.business.PlanOwnerBusiness;
import br.com.progol.training.management.model.Athlete;
import br.com.progol.training.management.model.PlanOwner;
import br.com.progol.training.management.util.JsonUtil;

@Controller
public class LoginController implements Serializable {

	@Autowired
	private AthleteBusiness athleteBusiness;
	
	@Autowired
	private PlanOwnerBusiness planOwnerBusiness;
	
	@Autowired
	private Result result;
	
	@Get("/login")
	public String loginPage(String userName, String password) {

		if ((userName == null || userName.isEmpty()) 
				&& (password == null || password.isEmpty())) {

			result.include("mensagem", PropertiesUtil.getMessagesValue("msg.usuario.senha.obrigatorios"));
			return "login";
		}
		
		PlanOwner planOwner = this.planOwnerBusiness.findBy(userName, password);
		
		if (planOwner != null) {

			planOwner.getAthleteList();
				
			return "login";	
		}
		
		return "home";
	}
	
	/**
	 * Method AJAX Example 
	 * 
	 * @param cpf
	 * @return
	 */
	@Get
	public String findAthleteByName(String name) {
		
		List<Athlete> athleteList = this.athleteBusiness.findByName(name);
		
		return JsonUtil.toJson(athleteList);
	}
	
}
