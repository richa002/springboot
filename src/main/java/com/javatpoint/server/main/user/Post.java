package com.javatpoint.server.main.user;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Acer
 */
@Entity
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen",  initialValue = 1)
public class Post {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="port_gen")
    private int id;
    private String name;
   // private String description;
    @ManyToOne()
    @JoinColumn(name="USER_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setPost(Post post){
    this.setId(post.getId());
    if(post.getName()!=null){
    this.setName(post.getName());
    }
    if(post.getUser()!=null){
    this.setUser(post.getUser());
    }
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Post(int id, String name, User user) {
        this.id = id;
        this.name = name;
       // this.description = description;
        this.user = user;
    }
    

    Post() {
        }

  
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
