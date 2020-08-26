/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.springbootrestcourseapi.course;

import com.richa.springbootrestcourseapi.topic.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Acer
 */
@Entity
public class Course {
    
    @Id
   @GeneratedValue
    private int id;
    private String name;
   // private String description;
    @ManyToOne()
    @JoinColumn(name="TOPIC_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }
 public void setCourse(Course course){
 this.id=course.getId();
 this.name=course.getName();
 this.topic=course.getTopic();
 
 }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Course(int id, String name, Topic topic) {
        this.id = id;
        this.name = name;
       // this.description = description;
        this.topic = topic;
    }
    

    Course() {
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
