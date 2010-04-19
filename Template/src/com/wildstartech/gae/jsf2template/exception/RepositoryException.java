package com.wildstartech.gae.jsf2template.exception;

/**
 * Exception of repository operations
 * @author Gleidson Moura
 *
 */
public class RepositoryException extends Exception {

	public RepositoryException() {
		super();
	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(Throwable cause) {
		super(cause);
	}
}
