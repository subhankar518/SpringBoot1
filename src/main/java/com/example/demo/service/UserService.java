package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Details;
import com.example.demo.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository ur;	
 	
	public String saveUser(Details details)
	{
	     try 
	   	 {   
	    	     Details dtl =ur.getDetailsByEmail(details.getEmail());
			     if(dtl==null)
			     {	
				        ur.save(details);
				        return ("New User added: "+details.getName());
			     }
			    	 
	   	 }
	   	 catch(Exception e)
	   	 {
	   		  e.printStackTrace();
	   	 }
		return ("User already Exist: "+details.getName());
	}
	
	public List<Details> allUser()
	{
		List<Details> details=new ArrayList<>();
		ur.findAll().forEach(Details->details.add(Details));
        return details; 
	}
	
	public void updateUser(Details details)
	{
		Details dtl1 =ur.getDetailsById(details.getId());
		dtl1.setName(dtl1.getName());
		dtl1.setEmail(dtl1.getEmail());
		ur.save(dtl1);
		
	}
	

}
