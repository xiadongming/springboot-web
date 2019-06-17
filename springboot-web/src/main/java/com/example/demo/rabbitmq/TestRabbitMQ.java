package com.example.demo.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.SpringbootWebApplication;
@SpringBootTest(classes=SpringbootWebApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQ {
	@Autowired
	private HelloSender helloSender;

	@Test
	public void testRabbit() {
		helloSender.send();
	}
}
