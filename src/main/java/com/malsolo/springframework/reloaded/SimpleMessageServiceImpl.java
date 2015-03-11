package com.malsolo.springframework.reloaded;

public class SimpleMessageServiceImpl implements MessageService {
	
	private final String message;
	
	public SimpleMessageServiceImpl(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
