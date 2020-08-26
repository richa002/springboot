/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.library.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Acer
 */
@Controller
public class UserResource {

    @Autowired
    UserRepository u_service;

    @GetMapping("/gotocreatenewaccountpage")
    public String gotocreatenewaccountpage() {
        return "createnewaccount";
    }

    @PostMapping("/createaccount")
    public String createaccount(Users user) {
        Users u = u_service.save(user);

        return "index";
    }

    @PostMapping("/checkcredentials")
    public String checkcredentials(Users user, HttpServletRequest req) {
         HttpSession session=req.getSession();  
        
        Users u = u_service.findByUsernameAndPasswordAndType(user.getUsername(), user.getPassword(),user.getType());
        if (u == null) {
            req.setAttribute("match", "no");
            return "index";
        } else {
            if(user.getType().equals("admin"))
            {
                session.setAttribute("logintype","admin");  
                return "admin_panel";
           }
        
            else{
                
            session.setAttribute("logintype","user");  
            session.setAttribute("uid",u.getUid());  
           
            return "user_panel";
        }
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
    
        return "index";
    
    }

        @GetMapping("/admin_panel")
    public String gotoadminpanel() {
       return "admin_panel";
    
}
    
        @GetMapping("/user_panel")
    public String gotouserpanel() {
       return "user_panel";
    
}

}