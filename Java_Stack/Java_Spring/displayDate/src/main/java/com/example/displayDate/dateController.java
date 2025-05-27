package com.example.displayDate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dateController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String showDate(Model model) {
		SimpleDateFormat formatDate = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
		String formattedDate = formatDate.format(new Date()).toString();
		model.addAttribute("date", formattedDate);
		return "datePage.jsp";
	}
	@RequestMapping("/time")
	public String showTime(Model model) {
		
		SimpleDateFormat formatDate = new SimpleDateFormat("h:mm a");		
		
		String formattedDate = formatDate.format(new Date()).toString();

		model.addAttribute("time", formattedDate);
		
		return "timePage.jsp";
	}
}