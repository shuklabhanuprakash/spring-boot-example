package com.practice.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.User;
import com.practice.service.UserService;

@RestController
@RequestMapping("/userService")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(){
		log.info("Inside getAllUsers");
		try{
		return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
		}catch(Exception e){
			
			log.error("Error",e);
		}
		return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
