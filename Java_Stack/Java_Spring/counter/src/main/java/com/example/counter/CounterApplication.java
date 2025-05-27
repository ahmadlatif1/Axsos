package com.example.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	
	@RequestMapping("")
	static String index(HttpSession session) {
		
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 0);
		}
		
		session.setAttribute("count", (Integer)session.getAttribute("count")+1);
		
		
		
		return "index.jsp";
	}
	
	@RequestMapping("/count")
	static String count(HttpSession session) {
		
		return "countpage.jsp";
	}
	

}
