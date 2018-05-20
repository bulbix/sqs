package com.bulbix.sqs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SqsApplicationTests {

@Autowired MessageService service;
	
	
	@Test
	public void contextLoads() {
		//service.send("sms.fifo", "Hola lfpq", "5534811548");
		service.send("sms.fifo", "SMS verification:1234", "5560088706");
	}

}
