/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.library.book;

import com.richa.library.issue.Issued;
import com.richa.library.issue.IssuedRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Acer
 */
@Controller
public class BookResource {

    @Autowired
    BookRepository b_service;
     

    @GetMapping("/gotoaddnewbookpage")
    public String gotoaddnewbookpage() {
        return "addnewbookpage";
    }

    @GetMapping("/gotosearchpage")
    public String gotosearchpage() {
        return "searchabookpage";
    }

    @GetMapping("/searchbyjsppage")
    public String searchbyjsppage(@RequestParam("searchby") String searchby, HttpServletRequest req) {
        //        req.setAttribute("searchby", searchby);
        return "searchbypage";
    }

    @GetMapping("/searchby")
    public ModelAndView searchby(ModelAndView mv, HttpServletRequest req) {

        List<Books> list = new ArrayList();
Books b=new Books();
        if (req.getParameter("bid") != null) {
            int bid = Integer.parseInt(req.getParameter("bid"));
           
            Optional<Books> b1 = b_service.findById(bid);
            if(!b1.isPresent()) {mv.setViewName("searchabookpage");
             req.setAttribute("msg","Sorry.. Book not found");
       
            return mv;}
            else{
                 b=b_service.findById(bid).get();
            list.add(b);
            }
        }
        String bookname = req.getParameter("bookname");
        String genre = req.getParameter("genre");

        if (bookname != null) {

           Optional<Books> b2 = b_service.findByBookname(bookname);
            if(!b2.isPresent()){mv.setViewName("searchabookpage");
             req.setAttribute("msg","Sorry.. Book not found");
       
            return mv;
            }
            else{
                b=b_service.findByBookname(bookname).get();
            
            list.add(b);}

        }
        if (genre != null) {

            list = b_service.findByGenre(genre);
            if(list.size()==0){ mv.setViewName("searchabookpage");
             req.setAttribute("msg","Sorry..No Book found");
       
            return mv;
            }
        }
      //  System.out.println(list.size());
        if(list.size()==0){
        mv.setViewName("admin_panel");
        }else
        {
        mv.addObject("list", list);
         req.setAttribute("msg1","yes");
       
        mv.setViewName("viewallbooksjsp");
        }
        return mv;
        
    }

    @PostMapping("/addbook")
    public String addbook(Books book, HttpServletRequest req) {
        Books b = b_service.save(book);
        if (b != null) {
            req.setAttribute("msg", "Book detail added successfully");
        }
        return "admin_panel";

    }

    @GetMapping("/viewlistofbooks")
    public ModelAndView viewlistofbooks(ModelAndView mv) {
        List<Books> listOfBooks = b_service.findAll();
        mv.addObject("list", listOfBooks);
        mv.setViewName("viewallbooksjsp");
        return mv;

    }

    @GetMapping("/gotoupdatebookjsp")
    public ModelAndView gotoupdatebookjsp(@RequestParam("id") int bid) {
        // b_service.save(book);
        ModelAndView mv = new ModelAndView("gotoupdatebookjsp");
        Books book = b_service.findById(bid).get();
        mv.addObject("Book", book);
        return mv;

    }

    @PostMapping("/updatebook")
    public ModelAndView updatebook(Books book, HttpServletRequest req, ModelAndView mv) {
        Books b = b_service.save(book);
        
        if (b != null) {
            req.setAttribute("msg", "Book detail updated successfully");
        }
        List<Books> listOfBooks = b_service.findAll();
        mv.addObject("list", listOfBooks);
        mv.setViewName("viewallbooksjsp");
        return mv;

    }

    @GetMapping("/deletebook")
    public ModelAndView deletebook(@RequestParam("id") int bid, HttpServletRequest req, ModelAndView mv) {
        b_service.deleteById(bid);
        req.setAttribute("msg", "Book detail  deleted successfully");

        List<Books> listOfBooks = b_service.findAll();
        mv.addObject("list", listOfBooks);
        mv.setViewName("viewallbooksjsp");
        return mv;

    }

    
}
