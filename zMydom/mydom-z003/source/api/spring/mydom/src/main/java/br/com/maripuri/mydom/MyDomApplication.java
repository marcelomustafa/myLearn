package br.com.maripuri.mydom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient   // Habilita o Eureka Server
public class MyDomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyDomApplication.class, args);
	}

}
