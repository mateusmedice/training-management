package br.com.cavy.training.management.util;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe para manipular as Mensagens do Sistema
 * 
 */
public class MessageUtil {

	/**
	 * Construtor Padrão
	 */
	public MessageUtil() { }

	/**
	 * Adiciona uma mensagem de Informação ao sistema
	 * @param mensagem
	 */
	public static void addInfo(String mensagem) {
		
		FacesContext.getCurrentInstance().addMessage(
			null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}

	/**
	 * Adiciona uma mensagem de Atenção ao Sistema
	 * @param mensagem
	 */
	public static void addWarn(String mensagem) {
		
		FacesContext.getCurrentInstance().addMessage(
			null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, ""));
	}

	/**
	 * Adiciona uma mensagem de Erro ao Sistema
	 * @param mensagem
	 */
	public static void addError(String mensagem) {
		
		FacesContext.getCurrentInstance().addMessage(
			null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	/**
	 * Adicionar uma mensagem de Erro Fatal ao Sistema
	 * @param mensagem
	 */
	public static void addFatal(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(
			null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, ""));
	}

	/**
	 * Verificar se existem mensagems (de erro/alerta) presentes no cache do JSF
	 * @param severidade - 
	 * @return boolean
	 */
	private static boolean isMensagensPresentes(FacesMessage.Severity severidade) {
		
		Iterator<FacesMessage> itMesages = 
			FacesContext.getCurrentInstance().getMessages();
		
		while (itMesages.hasNext()) {
			FacesMessage mensagem = itMesages.next();
			
			if (mensagem.getSeverity().equals(severidade)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Método responsável por verificar mensagens de informação.
	 * 
	 * @return True ou false para mensagens de informação presentes
	 */
	public static boolean verificarMensagensInformacaoPresentes() {
		return isMensagensPresentes(FacesMessage.SEVERITY_INFO);
	}
	
	/**
	 * Método responsável por verificar mensagens de erro.
	 * 
	 * @return True ou false para mensagens de erro presentes
	 */
	public static boolean verificarMensagensErroPresentes() {
		return isMensagensPresentes(FacesMessage.SEVERITY_ERROR);
	}
	
	/**
	 * Método responsável por verificar mensagens de alerta.
	 * 
	 * @return True ou false para mensagens de alerta presentes
	 */
	public static boolean verificarMensagensAlertaPresentes() {
		return isMensagensPresentes(FacesMessage.SEVERITY_WARN);
	}
	
}
