package com.malsolo.springframework.reloaded;

public class MessagePrinterWithMessageServiceImpl implements MessagePrinter {
	
	private final MessageService messageService;
	
	public MessagePrinterWithMessageServiceImpl(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	public void printMessage() {
		System.out.println(this.messageService.getMessage());
	}

}
