package com.harish.RabbitMQ.Demo.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class FinanceRabbitMQListner implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("Consuming in Finance Listener : "+ new String(message.getBody()));
	}

}
