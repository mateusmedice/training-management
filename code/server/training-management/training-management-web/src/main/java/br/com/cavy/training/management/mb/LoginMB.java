package br.com.cavy.training.management.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cavy.training.management.business.AthleteBusiness;
import br.com.cavy.training.management.business.PlanOwnerBusiness;
import br.com.cavy.training.management.model.Athlete;
import br.com.cavy.training.management.model.PlanOwner;
import br.com.cavy.training.management.util.JsonUtil;

@ManagedBean(name="loginMB")
@RequestScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 4488828851798122189L;

	@Autowired
	private AthleteBusiness athleteBusiness;
	
	@Autowired
	private PlanOwnerBusiness planOwnerBusiness;
	
	public String loginPage() {

		String userName = "";
		String password = "";
		
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
	public String findAthleteByName(String name) {
		
		List<Athlete> athleteList = this.athleteBusiness.findByName(name);
		
		return JsonUtil.toJson(athleteList);
	}
	
}
