package br.com.progol.training.management.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.progol.training.management.business.AthleteBusiness;
import br.com.progol.training.management.model.Athlete;
import br.com.progol.training.management.webservice.util.WebServiceUtil;

@RestController
@RequestMapping("/athelte")
public class AthleteWebService extends WebServiceUtil {
	
	@Autowired
	private AthleteBusiness athleteBusiness;

	@RequestMapping("/findByCpf")
	public String find(@RequestParam(value="cpf", required=true) String cpf) {
		
		Athlete athlete = athleteBusiness.findByCPF(cpf);
		
		return toJson(athlete);
	}
	
	@RequestMapping("/newTraining")
	public String newTrainig(@RequestParam(value="cpf", required=true) String cpf) {
		
		return toJson("");
	}

}
