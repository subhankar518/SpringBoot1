package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Details;
import com.example.demo.service.UserService;

@RestController
public class UserController 
{
	 @Autowired
     UserService us;
	 

     @PostMapping("/add-user")
     private ResponseEntity<Object> createUser(@RequestBody Details details)
     {
	     try 
	   	 {   
			    String val=	us.saveUser(details);
			    return new ResponseEntity<Object>(val, HttpStatus.CREATED);
			     
	   	 }
	   	 catch(Exception e)
	   	 {
	   		 return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	     }
     }
     
     @GetMapping("/all-users")
     private List<Details> getAllUsers() 
     {
			  return us.allUser();   
     }
     @PutMapping("/update_user")
     private ResponseEntity<?> updateUserCon(@RequestBody Details details)
     {
	     try 
	   	 {   
			    us.updateUser(details);			     
	   	 }
	   	 catch(Exception e)
	   	 {
	   		 return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	     return new ResponseEntity<Object>(details.getName()+" is updated", HttpStatus.OK);
     }
}
