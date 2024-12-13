package com.cursodevsuperior.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursodevsuperior.components.entities.Order;
import com.cursodevsuperior.components.services.OrderService;

@SpringBootApplication
public class ComponentsApplication implements CommandLineRunner{
	
	private OrderService orderService;
	
	public ComponentsApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ComponentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order1 = new Order(1034, 150.0, 20.0);
		Order order2 = new Order(2282, 800.0, 10.0);
		Order order3 = new Order(1309, 95.9, 0.0);
		
		System.out.println("Pedido código: " + order1.getCode());
		System.out.printf("Valor total: R$ %.2f\n", orderService.total(order1));
		System.out.println("");
		System.out.println("Pedido código: " + order2.getCode());
		System.out.printf("Valor total: R$ %.2f\n", orderService.total(order2));
		System.out.println("");
		System.out.println("Pedido código: " + order3.getCode());
		System.out.printf("Valor total: R$ %.2f\n", orderService.total(order3));
	}

}
