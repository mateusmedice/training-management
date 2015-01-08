package br.com.cavy.training.management.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.cavy.training.management.mb.BaseMB;
import br.com.cavy.training.management.mb.LoginMB;
import br.com.cavy.training.management.util.Constantes;

public class LoginPhaseListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6191792059742603940L;

	/**
	 * Método executado antes da fase
	 */
	public void beforePhase(PhaseEvent phaseEvent) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		String viewID = facesContext.getViewRoot().getViewId();

		boolean isLoginPage = (viewID.lastIndexOf("login.xhtml") > -1);
		
		boolean isNewUserPage = (viewID.lastIndexOf("newUser.xhtml") > -1);
	
		if (!isNewUserPage && !isLoginPage && !isUsuarioLogado()) {
			BaseMB.navegar(Constantes.LOGIN_PAGE, false);
			return;
		}
	}

	/**
	 * Verifica se o usuário está logado.
	 * 
	 * @param viewID - view ID
	 * 
	 * @return True or false
	 */
	public static boolean isUsuarioLogado() {

		return LoginMB.obterPlanOwnerDetails() != null;
	}

	/**
	 * Método executado depois da fase
	 */
	public void afterPhase(PhaseEvent arg0) {

	}

	/**
	 * Método que obtem o ID da Phase
	 */
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
