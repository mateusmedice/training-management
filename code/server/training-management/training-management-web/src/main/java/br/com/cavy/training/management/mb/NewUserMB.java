package br.com.cavy.training.management.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cavy.training.management.business.PlanOwnerBusiness;
import br.com.cavy.training.management.model.PlanOwner;
import br.com.cavy.training.management.util.Constantes;

@Component
@ManagedBean(name="newUserMB")
@RequestScoped
public class NewUserMB extends BaseMB {

	private static final long serialVersionUID = 737963118638715448L;

	private PlanOwner planOwner;
	
	@Autowired
	private PlanOwnerBusiness planOwnerBusiness;
	
	public NewUserMB() {
		if (this.getPlanOwner() == null) {
			this.setPlanOwner(new PlanOwner());
		}
	}
	
	public void save() {

		if (!this.validate()) {
			navegar(Constantes.HOME_PAGE, true);
		}
		
		PlanOwner planOwner = this.planOwnerBusiness.saveAndFind(this.planOwner);
		
		if (planOwner != null) {
			LoginMB loginMB = BaseMB.getBean("loginMB");
			loginMB.setPlanOwner(planOwner);
			loginMB.login();
		}
		
		navegar(Constantes.HOME_PAGE, true);
	}

	private boolean validate() {
		
		return true;
	}

	public PlanOwner getPlanOwner() {
		return planOwner;
	}

	public void setPlanOwner(PlanOwner planOwner) {
		this.planOwner = planOwner;
	}
	
}
