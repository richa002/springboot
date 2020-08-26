package com.javatpoint.server.main.user;
import java.net.URI;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.Resource;  
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;  
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
public class UserResource 
{
@Autowired
private UserRepository service;
@GetMapping("/users/{id}")
public Resource<User> retriveUser(@PathVariable int id)  
{  
Optional<User> user= service.findById(id);  
if(!user.isPresent())  
//runtime exception  
throw new UserNotFoundException("id: "+ id);  
//"all-users", SERVER_PATH + "/users"  
//retrieveAllUsers  
Resource<User> resource=new Resource<User>(user.get()); //user.get() returns a non null value of user//constructor of Resource class  
//add link to retrieve all the users  
ControllerLinkBuilder linkTo=linkTo(methodOn(this.getClass()).getAllUsers());  
resource.add(linkTo.withRel("all-users"));  
return resource;  
}  
//method that posts a new user detail and returns the status of the user resource
@PostMapping("/users")
public ResponseEntity<Object> createUser(@Valid @RequestBody User user)	
{ 
    
User sevedUser=service.save(user);	
URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedUser.getId()).toUri();
return ResponseEntity.created(location).build();
}

@GetMapping(path="/users")
  public Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return service.findAll();
  }
  @DeleteMapping(path="/users/{id}")
  public String  deleteuser(@PathVariable("id") int id) {
    // This returns a JSON or XML with the users
    Optional<User> user= service.findById(id);
    
if(user.isPresent())
{
    service.deleteById(id);
    return "Record deleted successfully";
     
}
else{ 
throw new UserNotFoundException("id :"+id);

  }
  }
  @PutMapping(path="/users/{id}")
  public User  updateuser(@RequestBody User user,@PathVariable("id") int id) {
    // This returns a JSON or XML with the users
     User u=service.findById(id).get();
     user.setId(id);
     u.setUser(user);
     service.save(u);
     return u; }

}