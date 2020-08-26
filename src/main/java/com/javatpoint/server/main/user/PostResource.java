package com.javatpoint.server.main.user;
import com.javatpoint.server.main.user.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
public class PostResource 
{
@Autowired
private PostRepository service;
@Autowired
private UserRepository u_service;

@GetMapping("/users/{id}/posts")
public  Iterable<Post> riveallposts(@PathVariable int id)  
{  
    
    if(u_service.findById(id).isPresent()){
return service.findByUserId(id); 
   //return  u_service.findById(id).get().getPosts();
    }
    else 
throw new UserNotFoundException("id :"+id);

}

@GetMapping("/users/{uid}/posts/{id}")
public Post retrivepost(@PathVariable("uid") int uid,@PathVariable("id") int id)  
{  
    
    if(u_service.findById(uid).isPresent()){
//return service.findByUserId(id); 
if(service.findById(id).isPresent())
   return service.findById(id).get();
   else 
   throw new UserNotFoundException(" Post id  not found:"+id);

    }
    else 
throw new UserNotFoundException(" User id  not found:"+uid);

}


/*public ResponseEntity<Object> createpost(@PathVariable int id, @RequestBody Post post)	
{
     if(!u_service.findById(id).isPresent()){
throw new UserNotFoundException("User id  not found:"+id);}
else{
    post.setUser(u_service.findById(id).get());
Post sevedPost=service.save(post);
    System.out.println(sevedPost);
URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{pid}").buildAndExpand(sevedPost.getId()).toUri();
return ResponseEntity.created(location).build();
}
}*/
@PostMapping("/users/{id}/posts")

    public Post addcourse(@RequestBody Post post,@PathVariable("id") int id)
    { 
        if(!u_service.findById(id).isPresent()){
         throw new UserNotFoundException("User id  not found:"+id);}

      
        post.setUser(new User(id,"",""));
    Post p=service.save(post);
        return p;
    }
   
    @PutMapping("/users/{uid}/posts/{id}")
    public Post updatepost(@PathVariable("uid") int uid,@RequestBody Post post,@PathVariable("id") int id)
    { 
            if(!u_service.findById(uid).isPresent())
        {
     throw new UserNotFoundException("User id  not found:"+uid);
        }
        if(!service.findById(id).isPresent())
        {
     throw new UserNotFoundException("Post id  not found:"+id);
        }
        Post p=service.findById(id).get();
        post.setId(id);
        post.setUser(new User(uid,"",""));
        p.setPost(post);
        service.save(p);
        return p;
            
       
    }
    
    @DeleteMapping("/users/{uid}/posts/{id}")

    public String deletepost(@PathVariable("uid") int uid,@PathVariable("id") int id)	
    {
         
         
         if(!u_service.existsById(uid))
         throw new UserNotFoundException("User id  not found:"+uid);
      
          if(!service.existsById(id))
         throw new UserNotFoundException("Post id  not found:"+id);
         if(service.existsById(id))
        service.deleteById(id);
        return "Post deleted";
         
          
        
        }
}
         


         