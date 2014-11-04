package br.com.progol.training.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.progol.training.management.business.AthleteBusiness;
import br.com.progol.training.management.business.PlanOwnerBusiness;
import br.com.progol.training.management.model.Athlete;
import br.com.progol.training.management.model.PlanOwner;
import br.com.progol.training.management.util.JsonUtil;
import br.com.progol.training.management.util.PropertiesUtil;

@Controller
public class LoginController {

	@Autowired
	private AthleteBusiness athleteBusiness;
	
	@Autowired
	private PlanOwnerBusiness planOwnerBusiness;
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public String loginPage(
		@RequestParam(value="userName", required=true) String userName, 
		@RequestParam(value="password", required=true) String password,
		Model model) {

		if ((userName == null || userName.isEmpty()) 
				&& (password == null || password.isEmpty())) {

			model.addAttribute("mensagem", PropertiesUtil.getMessagesValue("msg.usuario.senha.obrigatorios"));
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
	@RequestMapping(value="/findAthlete", method=RequestMethod.GET)
	public @ResponseBody String findAthleteByName(
		@RequestParam(value="name", required=true) String name) {
		
		List<Athlete> athleteList = this.athleteBusiness.findByName(name);
		
		return JsonUtil.toJson(athleteList);
	}
	
}
