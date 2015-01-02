package br.com.cavy.training.management.business.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6774805613973904795L;

	public BusinessException() {
		super();
	}
	
	public BusinessException(String msg) {
		super(msg);
	}
	
	public BusinessException(Throwable e) {
		super(e);
	}
	
	public BusinessException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
