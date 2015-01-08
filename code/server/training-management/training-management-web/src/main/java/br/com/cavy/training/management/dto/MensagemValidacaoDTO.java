package br.com.cavy.training.management.dto;

import java.io.Serializable;

public class MensagemValidacaoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2203856379252947904L;

	private String key;

	private String[] parametros;

	/**
	 * Construtor
	 * 
	 * @param key
	 *            Chave da mensagem da exceção
	 */
	public MensagemValidacaoDTO(String key) {
		this.key = key;
	}

	/**
	 * Construtor
	 * 
	 * @param key
	 *            Chave da mensagem da exceção
	 * @param parametros
	 *            Parâmetros da mensagem da exceção
	 */
	public MensagemValidacaoDTO(String key, String... parametros) {
		this.key = key;
		this.parametros = parametros;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the parametros
	 */
	public String[] getParametros() {
		return parametros;
	}

	/**
	 * @param parametros
	 *            the parametros to set
	 */
	public void setParametros(String[] parametros) {
		this.parametros = parametros;
	}
}
