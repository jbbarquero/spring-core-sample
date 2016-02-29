package com.malsolo.springframework.reloaded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MessagePrinterWithMessageServiceImpl implements MessagePrinter {
	
	private final MessageService messageService;
	
	@Autowired
	public MessagePrinterWithMessageServiceImpl(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	public void printMessage() {
		System.out.println(this.messageService.getMessage());
	}

}
