package br.com.cavy.training.management.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cavy.training.management.business.AthleteBusiness;
import br.com.cavy.training.management.business.PlanOwnerBusiness;
import br.com.cavy.training.management.model.PlanOwner;

@ManagedBean(name="loginMB")
@RequestScoped
@Component
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 4488828851798122189L;

	@Autowired
	private AthleteBusiness athleteBusiness;
	
	@Autowired
	private PlanOwnerBusiness planOwnerBusiness;
	
	private PlanOwner planOwner;
	
	public LoginMB() {
		if (this.planOwner == null) {
			this.planOwner = new PlanOwner();
		}
	}
	
	public String login() {

		PlanOwner planOwner = this.planOwnerBusiness.findBy(this.planOwner.getEmail(), this.planOwner.getPassword());
		
		if (planOwner == null) {

			return "/pages/maintenance/newUser";	
		}
		
		return "/pages/common/home";
	}

	public PlanOwner getPlanOwner() {
		return planOwner;
	}

	public void setPlanOwner(PlanOwner planOwner) {
		this.planOwner = planOwner;
	}
	
}
