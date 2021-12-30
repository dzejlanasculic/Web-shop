package com.et.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
  public String welcome(Model model) {
    model.addAttribute("greeting", "DOBRO DOŠLI");
    model.addAttribute("tagline","'Ljepota je još jedno obećanje sreće.'");
    return "welcome";
  }
  
  @RequestMapping("/welcome/greeting")
    public String greeting() {
    return "welcome";
    }
}
