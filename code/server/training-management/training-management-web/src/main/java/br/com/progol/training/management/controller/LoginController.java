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
import br.com.progol.training.management.model.Athlete;
import br.com.progol.training.management.util.JsonUtil;

@Controller
public class LoginController {

	@Autowired
	private AthleteBusiness athleteBusiness;
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public String loginPage(
		@RequestParam(value="userName", required=true) String userName, 
		@RequestParam(value="password", required=true) String password,
		Model model) {
				
		if(userName == null || password == null) {
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
