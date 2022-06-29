package com.things.customer.xcitycustomerskb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kbvault") // read vaultwiki for kbvault info
public class VaultConfig {

	private String username;

	private String password;

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
}
