package com.things.customer.xcitycustomerskb;

import com.things.customer.xcitycustomerskb.config.VaultConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(VaultConfig.class)
public class XcityCustomersKbApplication implements CommandLineRunner {
	private final VaultConfig vaultConfig;

	@Autowired
	public XcityCustomersKbApplication(VaultConfig vaultConfig) {
		this.vaultConfig = vaultConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(XcityCustomersKbApplication.class, args);
	}


	@Override
	public void run(String... args) {

		Logger logger = LoggerFactory.getLogger(XcityCustomersKbApplication.class);

		logger.info("----------------------------------------");
		logger.info("Configuration properties");
		logger.info("		example.username is {}", vaultConfig.getUsername());
		logger.info("		example.password is {}", vaultConfig.getPassword());
		logger.info("----------------------------------------");
	}
}
