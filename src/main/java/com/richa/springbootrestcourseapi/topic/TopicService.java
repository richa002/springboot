/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.springbootrestcourseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
//@Service
public class TopicService {
     List<Topic> topics= new ArrayList<Topic>();
    
     public TopicService(){
    
    topics.add(new Topic(101,"Java","Java Descriptions"));
     topics.add(new Topic(102,"Python","Python Descriptions"));
     topics.add(new Topic(103,"c++","c++ Descriptions"));
    
     }
     //Arrays.asList(new Topic(101,"Java","Java Descriptions"),new Topic(102,"Python","Python Descriptions"),new Topic(103,"C++","C++ Descriptions"));
    
public List<Topic> getAllTopics(){
    return topics;
}
public Topic getTopicById(int id)
{
  // return  topics.stream().filter(t->t.getId()==id);
    
    for(Topic t:topics){
    if(t.getId()==id) {return t;}
    }
     return  new Topic(0,"","");
}

    void addTopic(Topic topic) {
   topics.add(topic);
    }

    void updateTopic(int id, Topic topic) {
           for(Topic t:topics){
           if(t.getId()==id){
               t.setName(topic.getName());
            t.setDescription(topic.getDescription());
            return;
           }
           }
    
    }

    void deleteTopic(int id) {
        topics.removeIf(t->t.getId()==id);
    }
}


