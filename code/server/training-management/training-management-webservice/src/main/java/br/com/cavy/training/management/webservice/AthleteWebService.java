package br.com.cavy.training.management.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cavy.training.management.business.AthleteBusiness;
import br.com.cavy.training.management.model.Athlete;
import br.com.cavy.training.management.util.JsonUtil;

@Path("/athelte")
public class AthleteWebService {

	@Autowired
	private AthleteBusiness athleteBusiness;

	@GET
	@Path("/findByCpf/{cpf}")
	@Produces("application/json")
	public String find(@PathParam("cpf") String cpf) {

		Athlete athlete = this.athleteBusiness.findByCPF(cpf);

		return JsonUtil.toJson(athlete);
	}

	@GET
	@Path("/all")
	public String getAll() {

		return JsonUtil.toJson(this.athleteBusiness.getAll());
	}

}
