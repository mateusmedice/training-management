package br.com.cavy.training.management.mb;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import br.com.cavy.training.management.exception.ValidacaoException;
import br.com.cavy.training.management.util.Constantes;
import br.com.cavy.training.management.util.MessageUtil;

@SuppressWarnings("serial")
@Component("baseMB")
public class BaseMB implements Serializable {

	@SuppressWarnings("unused")
	private boolean existemMensagensAlerta = false;

	@SuppressWarnings("unused")
	private boolean existemMensagensErro = false;

	@SuppressWarnings("unused")
	private boolean existemMensagensSucesso = false;

	private boolean renderOperador;
	
	private boolean renderAdministrador;

	public boolean isRenderOperador() {
		return renderOperador;
	}

	public void setRenderOperador(boolean renderOperador) {
		this.renderOperador = renderOperador;
	}

	public boolean isRenderAdministrador() {
		return renderAdministrador;
	}

	public void setRenderAdministrador(boolean renderAdministrador) {
		this.renderAdministrador = renderAdministrador;
	}

	/**
	 * Armazena a key de validaï¿½ï¿½o quando a data for invï¿½lida
	 */
	private String idKeyDateValidationException = null;

	/**
	 * Armazena a descriï¿½ï¿½o da Exceï¿½ï¿½o ocorrida
	 */
	private String exceptionDescription = null;

	/**
	 * Armazena o StackTrace da Exceï¿½ï¿½o ocorrida
	 */
	private String exceptionStackTrace = null;

	/**
	 * Construtor padrï¿½o
	 */
	public BaseMB() {

	}

	public static String getParameter(String parameterName) {
		return (String) getExternalContext().getRequestMap().get(parameterName);
	}

	public static Object getSessionAttribute(String parameterName) {
		return getSession().getAttribute(parameterName);
	}

	public static void setSessionAtribute(String parameterName, Object value) {
		getSession().setAttribute(parameterName, value);
	}

	public static HttpSession getSession() {
		return (HttpSession) getExternalContext().getSession(true);
	}
	
	/**
	 * Mï¿½todo responsï¿½vel por obter o FacesContext.
	 * 
	 * @return Objeto do tipo FacesContext
	 */
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Método responsável por obter o ExternalContext.
	 * 
	 * @return ExternalContext
	 */
	public static ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	/**
	 * Mï¿½todo responsï¿½vel por encontrar um component.
	 * 
	 * @param componentParent
	 *            - Objetod do tipo UIComponent
	 * @param componentId
	 *            - Id do component
	 * 
	 * @return Objeto que estende UIComponent
	 */
	@SuppressWarnings("unchecked")
	public <E extends UIComponent> E findComponent(UIComponent componentParent, String componentId) {
		return (E) componentParent.findComponent(componentId);
	}

	/**
	 * Método responsável por exibir a página de erro com o StackTrace da
	 * exceção.
	 * 
	 * @param throwable
	 *            - Exceção a ser mostrada
	 */
	public void redirecionarParaPaginaErro(Throwable throwable) {

		BaseMB thisInstance = (BaseMB) getBean("baseMB");

		String mensagem = getMessage(throwable.getMessage());

		if (mensagem == null) {
			mensagem = throwable.getMessage();
		}

		this.setExceptionDescription(mensagem);

		thisInstance.setExceptionStackTrace(this.getStackTrace(throwable));

		navegar(Constantes.PAGINA_ERRO, true);
	}

	/**
	 * Método responsável por retornar a descrição da key passado como
	 * parâmetro.
	 * 
	 * @param key
	 *            - Key
	 * 
	 * @return Descrição
	 */
	public static String getMessage(String key) {

		if (key == null) {
			return null;
		}

		try {
			return getResourceBundle().getString(key);
		} catch (MissingResourceException e) {
			return null;
		}
	}

	/**
	 * Método responsável por obter o ResourceBundle.
	 * 
	 * @return Objeto do tipo ResourceBundle
	 */
	public static ResourceBundle getResourceBundle() {

		return ResourceBundle.getBundle("messages", getFacesContext()
				.getViewRoot().getLocale());

	}

	/**
	 * Método responsável por navegar para a página passada como parâmetro.
	 * 
	 * @param pagina
	 *            - Página
	 * @param redirect
	 *            -
	 */
	public static void navegar(String pagina, boolean redirect) {

		if (pagina == null) {
			return;
		}

		FacesContext facesContext = getFacesContext();

		if (redirect) {

			try {

				ExternalContext externalContext = facesContext.getExternalContext();

				externalContext.redirect(externalContext.getRequestContextPath() + pagina);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		} else {

			Application application = facesContext.getApplication();
			ViewHandler viewHandler = application.getViewHandler();
			UIViewRoot viewRoot = viewHandler.createView(facesContext, pagina);

			facesContext.setViewRoot(viewRoot);
		}

	}

	/**
	 * Efetua parse do nome de um Bean com EL e retorna a instancia.
	 * 
	 * @param beanName
	 *            - Nome do Bean
	 * @return A instancia do Bean
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Object> E getBean(String beanName) {

		ELContext elc = getFacesContext().getELContext();
		ELResolver elr = elc.getELResolver();

		return (E) elr.getValue(elc, null, beanName);

	}

	/**
	 * Mï¿½todo responsï¿½vel por retornar o stackTrace da exceï¿½ï¿½o.
	 * 
	 * @param e
	 *            - Exceção
	 * 
	 * @return StackTrace da exceção
	 */
	private String getStackTrace(Throwable e) {

		StringWriter writer = new StringWriter();

		PrintWriter pw = new PrintWriter(writer);

		e.printStackTrace(pw);

		return writer.toString();
	}
	
	public void lancarExcecaoDataInvalida() throws ValidacaoException {
		throw new ValidacaoException(idKeyDateValidationException);
	}

	public boolean isExistemMensagensAlerta() {
		return MessageUtil.verificarMensagensAlertaPresentes();
	}

	public boolean isExistemMensagensErro() {
		return MessageUtil.verificarMensagensErroPresentes();
	}

	public boolean isExistemMensagensSucesso() {
		return MessageUtil.verificarMensagensInformacaoPresentes();
	}
	
	/**
	 * Retorna o StackTrace da Exceï¿½ï¿½o ocorrida
	 * 
	 * @return
	 */
	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	/**
	 * Atribui o StackTrace da Exceï¿½ï¿½o ocorrida
	 * 
	 * @param exceptionStackTrace
	 */
	public void setExceptionStackTrace(String exceptionStackTrace) {
		this.exceptionStackTrace = exceptionStackTrace;
	}

	/**
	 * Retorna a descriï¿½ï¿½o da Exceï¿½ï¿½o ocorrida
	 * 
	 * @return
	 */
	public String getExceptionDescription() {
		return exceptionDescription;
	}

	/**
	 * Atribui a descriï¿½ï¿½o da Exceï¿½ï¿½o ocorrida
	 * 
	 * @param exceptionDescription
	 */
	public void setExceptionDescription(String exceptionDescription) {
		this.exceptionDescription = exceptionDescription;
	}

	/**
	 * Retorna a key para problemas de validaï¿½ï¿½o de datas
	 * 
	 * @return
	 */
	public String getIdKeyDateValidationException() {
		return idKeyDateValidationException;
	}

	/**
	 * Atribui a key para problemas de validaï¿½ï¿½o de datas
	 * 
	 * @param idKeyDateValidationException
	 */
	public void setIdKeyDateValidationException(
			String idKeyDateValidationException) {
		this.idKeyDateValidationException = idKeyDateValidationException;
	}

}
