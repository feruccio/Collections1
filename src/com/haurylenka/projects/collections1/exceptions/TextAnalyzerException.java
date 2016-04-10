package com.haurylenka.projects.collections1.exceptions;

public class TextAnalyzerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TextAnalyzerException() {
		super();
	}

	public TextAnalyzerException(String message, Throwable cause) {
		super(message, cause);
	}

	public TextAnalyzerException(String message) {
		super(message);
	}

}
