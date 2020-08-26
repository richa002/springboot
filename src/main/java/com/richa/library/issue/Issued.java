/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.library.issue;

import com.richa.library.book.Books;
import com.richa.library.user.Users;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Acer
 */
@Entity
public class Issued {
    @Id
    @GenericGenerator(
        name = "issueid-sequence-generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "issueid_sequence"),
                @Parameter(name = "initial_value", value = "1001"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@GeneratedValue(generator = "issueid-sequence-generator")
    private int issueId;
    private String status;

   
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public Issued() {
    }
   @ManyToOne()
    @JoinColumn(name="USER_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;

    
     @ManyToOne()
    @JoinColumn(name="BOOK_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Books book;

    
    
    
    
    
    private String bookname;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
     @Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern = "dd/MM/yyyy")
 
    private Date issueDate;
      @Temporal(TemporalType.DATE)
      @DateTimeFormat(pattern="dd/MM/yyyy")

       //@DateTimeFormat(pattern = "dd/MM/yyyy")
 
    private Date toBeReturnedOn;
      @Temporal(TemporalType.DATE)
       @DateTimeFormat(pattern = "dd/MM/yyyy")
 
    private Date returnedOn;
    private int period;
    private int fine;

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

   
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Issued(int issueId, String status, Users user, Books book, String bookname, Date issueDate, Date toBeReturnedOn, Date returnedOn, int period, int fine) {
        this.issueId = issueId;
        this.status = status;
        this.user = user;
        this.book = book;
        this.bookname = bookname;
        this.issueDate = issueDate;
        this.toBeReturnedOn = toBeReturnedOn;
        this.returnedOn = returnedOn;
        this.period = period;
        this.fine = fine;
    }

  
    public Date getToBeReturnedOn() {
        return toBeReturnedOn;
    }

    public void setToBeReturnedOn(Date toBeReturnedOn) {
        this.toBeReturnedOn = toBeReturnedOn;
    }

    public Date getReturnedOn() {
        return returnedOn;
    }

    public void setReturnedOn(Date returnedOn) {
        this.returnedOn = returnedOn;
    }

   public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    
    
    
}
