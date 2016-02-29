package com.malsolo.springframework.reloaded;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MessagePrinterTest {
	
	@Autowired
	MessagePrinter messagePrinter;

	@Test
	public void testMarkerMethod() {
	}
	
	@Test
	public void testPrintMessage() {
		this.messagePrinter.printMessage();
	}
}
