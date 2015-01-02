package br.com.cavy.training.management.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cavy.training.management.business.PlanOwnerBusiness;
import br.com.cavy.training.management.model.PlanOwner;
import br.com.cavy.training.management.util.ManagedBeanUtils;

@Component
@ManagedBean(name="newUserMB")
@RequestScoped
public class NewUserMB implements Serializable {

	private PlanOwner planOwner;
	
	@Autowired
	private PlanOwnerBusiness planOwnerBusiness;
	
	public NewUserMB() {
		if (this.getPlanOwner() == null) {
			this.setPlanOwner(new PlanOwner());
		}
	}
	
	public String save() {

		validate();
		
		PlanOwner planOwner = this.planOwnerBusiness.save(this.planOwner);
		
		if (planOwner != null) {
		
			ManagedBeanUtils.setSessionParam("planOwner", planOwner);
		}
		
		return "pages/common/home";
	}

	private void validate() {
		
		
	}

	public PlanOwner getPlanOwner() {
		return planOwner;
	}

	public void setPlanOwner(PlanOwner planOwner) {
		this.planOwner = planOwner;
	}
	
}
