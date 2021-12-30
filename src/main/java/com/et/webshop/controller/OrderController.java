package com.et.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.et.webshop.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/P1234/45")
	public String process() {
		orderService.processOrder("P1234", 45);
		return "redirect:/products";
	}
}
