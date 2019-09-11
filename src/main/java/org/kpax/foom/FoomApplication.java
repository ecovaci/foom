package org.kpax.foom;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FoomApplication {

	public static void main(String[] args) {
		Application.launch(JavafxApplication.class, args);
	}

}
