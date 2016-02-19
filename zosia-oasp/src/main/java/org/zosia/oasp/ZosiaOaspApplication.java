package org.zosia.oasp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "org.zosia.oasp")
@SpringBootApplication
public class ZosiaOaspApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZosiaOaspApplication.class, args);
	}
}
