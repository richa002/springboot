/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.library.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 *
 * @author Acer
 */
@Entity
public class Books {
    @Id
   @GenericGenerator(
        name = "bookid-sequence-generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "book_sequence"),
                @Parameter(name = "initial_value", value = "101"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@GeneratedValue(generator = "bookid-sequence-generator")
   
    private int bid;
    private String bookname;
    private String genre;
    private int  copies;

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
    private int price;

    @Override
    public String toString() {
        return "Book {" + "bid=" + bid + ", bookname=" + bookname + ", genre=" + genre + ", price=" + price + '}';
    }

    public Books(int bid, String bookname, String genre, int price ,int copies) {
        this.bid = bid;
        this.bookname = bookname;
        this.genre = genre;
        this.price = price;
        this.copies=copies;
    }

    public Books() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
