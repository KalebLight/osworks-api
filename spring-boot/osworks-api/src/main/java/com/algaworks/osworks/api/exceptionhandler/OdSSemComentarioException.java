package com.algaworks.osworks.api.exceptionhandler;

import com.algaworks.osworks.domain.exception.NegocioException;

public class OdSSemComentarioException extends NegocioException {

	private static final long serialVersionUID = 1L;
	
	public OdSSemComentarioException(String message) {
		super(message);
	}
}
