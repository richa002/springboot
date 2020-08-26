/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.springbootrestcourseapi.topic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Acer
 */
@Entity
public class Topic {
    
    @Id
    @GeneratedValue
    @Column(name="TOPIC_ID")
    private int id;
    private String name;
    private String description;

    public Topic(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    Topic() {
        }

  
    @Override
    public String toString() {
        return "Topic{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
