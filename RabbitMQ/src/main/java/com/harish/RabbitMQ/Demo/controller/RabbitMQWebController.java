package com.harish.RabbitMQ.Demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.RabbitMQ.Demo.model.Employee;
import com.harish.RabbitMQ.Demo.service.RabbitMQSender;

@RestController
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer() {
		
		Employee empForAdmin = new Employee();
		empForAdmin.setEmpId("AdminEmployee");
		empForAdmin.setEmpName("emp001");
		
		Employee empForFinance = new Employee();
		empForFinance.setEmpId("FinanceEmployee");
		empForFinance.setEmpName("emp003");
		
		
		rabbitMQSender.sendToAdmin(empForAdmin);
		//rabbitMQSender.sendToFinance(empForFinance);
		
		
		return "Message sent to the RabbitMQ Successfully";
	}

}