package com.malsolo.springframework.core.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomServiceTest {
	
	@Autowired
	CustomService customService;

	@Test
	public void testMarkerMethod() {
	}
	
	@Test
	public void testInfo() {
		this.customService.info();
	}
	
	@Test
	public void testRun() {
		this.customService.run();
	}

}
