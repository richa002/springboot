/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.springbootrestcourseapi.course;

import com.richa.springbootrestcourseapi.topic.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class CourseController {
   @Autowired
   CourseRepository repo;
   //TopicService topicService;
    @RequestMapping("/topics/{id}/courses")
    public List<Course> getallcourses(@PathVariable("id") int id)
    {
   // return topicService.getAllTopics();
        return (List<Course>) repo.findByTopicId(id);
    }
    
    @GetMapping("/topics/{topicid}/courses/{id}")
    public Object getcoursebyid(@PathVariable("id") int id)
    {
    //Topic t= topicService.getTopicById(id);
      //  System.out.println(t);
         if(repo.existsById(id)){
      
           Optional<Course> t=repo.findById(id);
               return t;}
         else return "Course not found";
    }
    
    @PostMapping("/topics/{id}/courses")

    public Course addcourse(@RequestBody Course course,@PathVariable("id") int id)
    {
     // topicService.addTopic(topic);
        course.setTopic(new Topic(id,"",""));
    Course c=repo.save(course);
        return c;
    }
    
    @PutMapping("/topics/{topicid}/courses/{id}")
    public Course updatecourse(@PathVariable("topicid") int topicid,@RequestBody Course course,@PathVariable("id") int id)
    {    course.setId(id);
         course.setTopic(new Topic(topicid,"",""));
         Course c=repo.findById(id).get();
        c.setCourse(course);
     repo.save(c);
        return c;
             
       
    }
     @DeleteMapping("/topics/{topicid}/courses/{id}")
    public String deletecourse(@PathVariable("id") int id)
    { 
         if(repo.existsById(id)){
        repo.deleteById(id);
        return "Course deleted";
         }else return "course not found";
       
    }
    }
    

