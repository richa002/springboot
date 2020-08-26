/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.springbootrestcourseapi.topic;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Acer
 */
@RestController
public class TopicController {
   @Autowired
   TopicRepository repo;
   //TopicService topicService;
    @RequestMapping("/topics")
    public List<Topic> getalltopics()
    {
   // return topicService.getAllTopics();
        return (List<Topic>) repo.findAll();
    }
    
    @RequestMapping("/topics/{id}")
    public Object gettopicbyid(@PathVariable("id") int id)
    {
    //Topic t= topicService.getTopicById(id);
      //  System.out.println(t);
         if(repo.existsById(id)){
      
           Optional<Topic> t=repo.findById(id);
               return t;}
         else return "Topic not found";
    }
    
    @PostMapping("/topics")

    public Topic addtopic(@RequestBody Topic topic)
    {
     // topicService.addTopic(topic);
    Topic t=repo.save(topic);
        return t;
    }
    
    @PutMapping("/topics/{id}")
    public Topic updatetopic(@PathVariable("id") int id,@RequestBody Topic topic)
    { 
        //Topic t= topicService.getTopicById(id);
        
             
        
    Topic t=repo.save(topic);
        return t;
    }
     @DeleteMapping("/topics/{id}")
    public String deletetopic(@PathVariable("id") int id)
    { 
        //Topic t= topicService.getTopicById(id);
        if(repo.existsById(id)){
      repo.deleteById(id);
        return "Topic deleted";
        }else return "topic not found";
        
       
    }
    }
    

