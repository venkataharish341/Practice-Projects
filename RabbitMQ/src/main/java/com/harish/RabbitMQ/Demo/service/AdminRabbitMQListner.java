package com.harish.RabbitMQ.Demo.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author htavva
 * Listener class for listening to queue. Configuration defined in RabbitMQConfig class.
 */
public class AdminRabbitMQListner implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("Consuming in Admin Listener : "+ new String(message.getBody()));
	}

}
