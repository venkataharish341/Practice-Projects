package com.learn2earn.todo.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// Using @ConfigurationProperties help to make the properties defined type safe and
// we can also have validations on the fields.
@Configuration
@ConfigurationProperties(prefix= "spring.rabbitmq")
public class RabbitConfigProperties {
	
	private String host;
	private String username;
	private String password;
	private String port;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
}
