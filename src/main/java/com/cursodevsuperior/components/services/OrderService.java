package com.cursodevsuperior.components.services;

import org.springframework.stereotype.Service;

import com.cursodevsuperior.components.entities.Order;

@Service
public class OrderService {
	
	private ShippingService shippingService;

	public OrderService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	public double total(Order order) {
		return discountedValue(order) + shippingService.shipment(order);
	}
	
	private double discountedValue(Order order) {
		return order.getBasic() * (1 - order.getDiscount() / 100);
	}
}
