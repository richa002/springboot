package com.richa.library;

import com.richa.library.user.UserRepository;
import com.richa.library.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
@Controller
public class LibraryApplication {

    @Autowired
    UserRepository u_service;
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

        @GetMapping("/")
	public String index(){
        return "index";
        }
            
}
