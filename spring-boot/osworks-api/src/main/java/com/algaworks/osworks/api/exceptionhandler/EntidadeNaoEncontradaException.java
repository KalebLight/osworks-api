package com.algaworks.osworks.api.exceptionhandler;

import com.algaworks.osworks.domain.exception.NegocioException;

public class EntidadeNaoEncontradaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String message) {
		super(message);

	}

	
}
