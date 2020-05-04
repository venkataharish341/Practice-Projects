package com.harish.RabbitMQ.Demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.harish.RabbitMQ.Demo.model.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${harish.rabbitmq.exchange}")
	private String exchange;

	@Value("${harish.rabbitmq.adminRoutingkey}")
	private String adminRoutingkey;

	@Value("${harish.rabbitmq.financeRoutingkey}")
	private String financeRoutingkey;

	public void sendToAdmin(Employee employee) {
		rabbitTemplate.convertAndSend(exchange, adminRoutingkey, employee);
		System.out.println("Send msg = " + employee);
	}

	public void sendToFinance(Employee employee) {
		rabbitTemplate.convertAndSend(exchange, financeRoutingkey, employee);
		System.out.println("Send msg = " + employee);
	}

}