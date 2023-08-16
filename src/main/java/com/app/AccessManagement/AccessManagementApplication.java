package com.app.AccessManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.app.AccessManagement") // Asegura el escaneo de componentes en este paquete y
//subpaquetes
public class AccessManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessManagementApplication.class, args);
	}

}
