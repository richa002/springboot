/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.library.issue;

import com.richa.library.book.BookRepository;
import com.richa.library.book.Books;
import com.richa.library.user.UserRepository;
import com.richa.library.user.Users;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Acer
 */
@Controller
public class IssuedResource {

    @Autowired
    IssuedRepository i_service;
    @Autowired
    BookRepository b_service;
    @Autowired
    UserRepository u_service;

    @GetMapping("/gotoissuebookform")
    public String gotoissuebookform() {
        return "issuebookformjsp";
    }

    @GetMapping("/issuebook")
    public String issuebookmethod(HttpServletRequest req) throws ParseException {
int bid = Integer.parseInt(req.getParameter("bid"));
Books book = b_service.findById(bid).get();
        
        if(book.getCopies()==0)
        {
          req.setAttribute("msg", "Book currently not available");
           return "admin_panel";

        }
        else{
        Issued issued = new Issued();
        issued.setBook(book);
book.setCopies(book.getCopies()-1);
        issued.setBookname(book.getBookname());
        int uid = Integer.parseInt(req.getParameter("uid"));
        Users user = u_service.findById(uid).get();
        issued.setUser(user);

        //   issued.setUid(Integer.parseInt(req.getParameter("uid")));
        Date d1=new Date();
        issued.setIssueDate(d1);
        Date d2=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("toBeReturnedOn"));
       
        long difference =  (d1.getTime()-d2.getTime())/86400000;
        int period=(int) Math.abs(difference)+1;
      //  issued.setFine(5);
        
        issued.setPeriod(period);
        issued.setToBeReturnedOn(d2);
 
        issued.setStatus("issued");
        Issued i = i_service.save(issued);
        int issueid = i.getIssueId();
        if (i != null) {
            req.setAttribute("msg", "Book issued successfully on issue id :" + issueid);
        }

        return "admin_panel";
        }
    }
    

    @GetMapping("/gotoissuehistory")
    public ModelAndView gotoissuehistory(ModelAndView mv, HttpServletRequest req) {
        HttpSession session=req.getSession();  
         List<Issued> list=new ArrayList();
        String n=(String)session.getAttribute("logintype");  
       if(n.equals("admin"))
       list = i_service.findAll();
       else{
           int uid=(Integer)session.getAttribute("uid");  
           list= i_service.findByUserUid(uid);
                   }
                   mv.addObject("list", list);
        mv.addObject("list", list);
        mv.setViewName("issuehistoryjsp");
        return mv;

    }

    @GetMapping("/returnbookjsp")
    public ModelAndView returnbookjsp(ModelAndView mv,HttpServletRequest req,@RequestParam("id") int issueId) {
  Issued  issued=i_service.findById(issueId).get();
  if(issued.getStatus().equals("Returned")){
       List<Issued> list=new ArrayList();
        list=i_service.findAll();
        mv.addObject("list", list);
       
     
   req.setAttribute("msg", "Book is already returned.");
mv.setViewName("issuehistoryjsp");
return mv;
  }  else{
        mv.addObject("issued", issued);
      //  issued.findfine();
       // mv.addObject("list", list);
        mv.setViewName("returnbookform");
        return mv;
  }
    }
    @GetMapping("/returnbook")
    public String returnbook(HttpServletRequest req ) throws ParseException{
int issueid=Integer.parseInt(req.getParameter("issueid")) ;
 Issued  issued=i_service.findById(issueid).get();
 String strd1=req.getParameter("toBeReturnedOn");
 String strd2=req.getParameter("returnDate");
 Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(strd1);  
 Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(strd2);  
  // Date d2=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter(""));
       
  //Date d1=new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("toBeReturnedOn"));
   //Date d2=new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("ReturnDate"));
 
      
  issued.setReturnedOn(date2);
  Books book=issued.getBook();
  Books book2=b_service.findById(book.getBid()).get();
  book2.setCopies(book.getCopies()+1);
  if(issued.getToBeReturnedOn().getTime()>=issued.getReturnedOn().getTime())
  { 
      issued.setFine(0); 
  }
  else{
  long difference =  (issued.getToBeReturnedOn().getTime()-issued.getReturnedOn().getTime())/86400000;
    
   
        int period=(int) Math.abs(difference);
        
        issued.setFine(period*10);
    
  }
  if(issued.getFine()==0)
  issued.setStatus("Returned");
  else
    issued.setStatus("Fine collected and Book returned"); 
  i_service.save(issued);
 req.setAttribute("msg", "Book returned successfully on issue id :" + issueid);
        
  return "admin_panel";

    }

    @GetMapping("/reissuebookjsp")
    public ModelAndView reissuebookjsp(ModelAndView mv,HttpServletRequest req,@RequestParam("id") int issueId) {
 
        Issued  issued=i_service.findById(issueId).get();
        if(issued.getStatus().equals("issued")){
        mv.addObject("issued", issued);
      
        mv.setViewName("reissuebookform");
        return mv;
      }
      if(issued.getStatus().equals("Re-Issued"))
      {
          req.setAttribute("msg", "Book is already re-issued once.. Re-issue is possible only once on a single issue id..");
      List<Issued> list=new ArrayList();
        list=i_service.findAll();
        mv.addObject("list", list);
          mv.setViewName("issuehistoryjsp");
     
      }
      if(issued.getStatus().equals("Returned"))
      {
           List<Issued> list=new ArrayList();
        list=i_service.findAll();
        mv.addObject("list", list);
        req.setAttribute("msg", "Book is already returned. Initiate a fresh issue request.");
         mv.setViewName("issuehistoryjsp");
   
      }
     return mv;
     

    }
    
    
    @GetMapping("/reissuebook")
    public String reissuebook(HttpServletRequest req) throws ParseException {

int issueid=Integer.parseInt(req.getParameter("issueid")) ;
 Issued  issued=i_service.findById(issueid).get();
 String strd1=req.getParameter("toBeReturnedOn");
 String strd2=req.getParameter("issueDate");
 Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(strd1);  
 Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(strd2);  
 issued.setIssueDate(date2);
issued.setToBeReturnedOn(date1);
issued.setStatus("Re-Issued");
       
        long difference =  (date1.getTime()-date2.getTime())/86400000;
        int period=(int) Math.abs(difference);
        
        issued.setPeriod(period);
        
       
        Issued i = i_service.save(issued);
       // int issueid = i.getIssueId();
        if (i != null) {
            req.setAttribute("msg", "Book issued successfully on issue id :" + issueid);
        }

        return "admin_panel";

    }
    }


