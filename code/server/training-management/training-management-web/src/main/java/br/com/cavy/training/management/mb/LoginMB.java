package br.com.cavy.training.management.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cavy.training.management.business.AthleteBusiness;
import br.com.cavy.training.management.business.PlanOwnerBusiness;
import br.com.cavy.training.management.model.PlanOwner;
import br.com.cavy.training.management.util.Constantes;

@Component
@ManagedBean(name="loginMB")
@RequestScoped
public class LoginMB extends BaseMB {

	private static final long serialVersionUID = 4488828851798122189L;

	@Autowired
	private AthleteBusiness athleteBusiness;
	
	@Autowired
	private PlanOwnerBusiness planOwnerBusiness;
	
	private PlanOwner planOwner;
	
	private Boolean isLoggedIn;
	
	public LoginMB() {
		if (this.planOwner == null) {
			this.planOwner = new PlanOwner();
		}
		
		this.isLoggedIn = false;
	}
	
	public void login() {

		PlanOwner planOwner = this.planOwnerBusiness.findBy(this.planOwner.getEmail(), this.planOwner.getPassword());
		
		if (planOwner == null) {
			navegar(Constantes.NEW_USER_PAGE, true);
		}

		setSessionAtribute("planOwner", planOwner);
		
		BeanUtils.copyProperties(planOwner, this.planOwner);
		
		this.isLoggedIn = true;
		
		navegar(Constantes.HOME_PAGE, true);
	}
	
	public void logout() {
		
		HttpSession session = getSession();
		
		if (session != null) {
			session.removeAttribute("planOwner");
			session.invalidate();
			this.isLoggedIn = false;
		}
		
		navegar(Constantes.LOGIN_PAGE, true); 
	}
	
	public static PlanOwner obterPlanOwnerDetails() {
		
		return (PlanOwner) getSessionAttribute("planOwner");
	}

	public PlanOwner getPlanOwner() {
		return planOwner;
	}

	public void setPlanOwner(PlanOwner planOwner) {
		this.planOwner = planOwner;
	}

	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
}
