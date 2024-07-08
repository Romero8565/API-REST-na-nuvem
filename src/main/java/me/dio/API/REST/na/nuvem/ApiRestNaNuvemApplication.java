package me.dio.API.REST.na.nuvem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "default server URL")})
@SpringBootApplication
public class ApiRestNaNuvemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestNaNuvemApplication.class, args);
	}

}
