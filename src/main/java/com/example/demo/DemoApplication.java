package com.example.demo;

import static javafx.scene.input.KeyCode.I;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/hello")
	/*public String html(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
*/
        /*
        public ModelAndView html(@RequestParam("name") String name) {
    ModelAndView mv=new ModelAndView();
    mv.addObject("name", name);
    mv.setViewName("greeting");
    return mv;
	}
*/
        public ModelAndView html(Alien alien) {
		ModelAndView mv=new ModelAndView();
    mv.addObject("obj",alien);
    mv.setViewName("greeting");
    return mv;}
        
        @GetMapping("/next")
        
	public String next(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "next";
	}
}
