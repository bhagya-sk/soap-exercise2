package com.reactiveworks.productwebservice.dao.exceptions;

public class DaoOperationFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoOperationFailureException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoOperationFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	
	public DaoOperationFailureException(String message, Throwable cause) {
		super( message , cause);
		// TODO Auto-generated constructor stub
	}

	public DaoOperationFailureException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DaoOperationFailureException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
