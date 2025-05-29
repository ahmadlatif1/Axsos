package com.example.omikuji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class OmikujiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmikujiApplication.class, args);
	}
	
	
	
	@RequestMapping("/omikuji")
	static String showform() {
		return "index.jsp";
		
	}
	
	@PostMapping("/omikuji/show/")
	static String showresult(HttpSession session, @RequestParam MultiValueMap<String,String> params){
		
	
		
		String name = params.getFirst("name");
		String city = params.getFirst("city");
		String animal = params.getFirst("animal");
		String person = params.getFirst("person");
		String hobby = params.getFirst("hobby");
		String message = params.getFirst("message");
		String number = params.getFirst("number");
		
		String result="In "+ number + " years, you will live in "+city+" with "+ person+" as your roommate, doing "+hobby+" for a living, the next time you see a "+animal+", you will have good luck, also, "+message+"." ;

		session.setAttribute("result", result);
		
		
		return "showpage.jsp";
	}

}
