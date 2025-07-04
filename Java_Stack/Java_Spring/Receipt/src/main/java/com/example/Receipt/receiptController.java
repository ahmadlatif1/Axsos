package com.example.Receipt;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class receiptController {
    @RequestMapping("")
	public String index(Model model) {


		String name = "Grace Hopper";
		String itemName = "Copper wire";
		double price = 5.25;
		String description = "Metal strips, also an illustration of nanoseconds.";
		String vendor = "Little Things Corner Store";

		// Your code here! Add values to the view model to be rendered

		model.addAllAttributes(Map.of(
				"name", name,
				"itemName", itemName,
				"price", price,
				"description", description,
				"vendor", vendor
		));
		return "index.jsp";
	}
}
