package br.com.cavy.training.management.exception;

import java.util.List;

import br.com.cavy.training.management.dto.MensagemValidacaoDTO;

public class ValidacaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2802671427180268526L;
	
	private List<MensagemValidacaoDTO> listaMensagensValidacao = null;

	/**
	 * Construtor padrão
	 */
	public ValidacaoException() {
	}

	/**
	 * Construtor que atribui a mensagem ocorrida na validação
	 * 
	 * @param msg
	 *            - Descrição do problema ocorrido
	 */
	public ValidacaoException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor que atribui uma lista de mensagens de validação.
	 * 
	 * @param listaMensagensValidacao - Lista de mensagens de validação
	 */
	public ValidacaoException(List<MensagemValidacaoDTO> listaMensagensValidacao) {
		this.setListaMensagensValidacao(listaMensagensValidacao);
	}

	/**
	 * Retorna uma lista com as mensagens de validação ocorridas
	 * 
	 * @return List
	 */
	public List<MensagemValidacaoDTO> getListaMensagensValidacao() {
		return listaMensagensValidacao;
	}

	/**
	 * Atribui uma lista com as mensagens de validação ocorridas
	 * 
	 * @param listaMensagensValidacao
	 */
	public void setListaMensagensValidacao(List<MensagemValidacaoDTO> listaMensagensValidacao) {
		this.listaMensagensValidacao = listaMensagensValidacao;
	}
}
