package com.example.HelloHuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}

	@RequestMapping("/")
	public String index(@RequestParam(value = "name",required = false) String firstname,@RequestParam(value = "lastname", required = false) String lastname,@RequestParam(value = "times",required = false) String times){
		if (lastname==null)lastname="";
		if (firstname==null)firstname="Human";
		int n=1;
		if(times!=null){
			try{
				n=Integer.parseInt(times);

			} catch (Exception e) {
				n=1;
            }
		}
		return "Hello, %s %s".formatted(firstname, lastname).repeat(n);

	}

}
