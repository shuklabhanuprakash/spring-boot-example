package com.practice.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		log.info("Inside getAllUsers");
		try {
			return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {

			log.error("Error", e);
		}
		return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findUserById(@PathVariable("id") Integer id) {
		log.info("Inside findUserById and id is " + id);

		try {
			if (null == id) {
				new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			}
			User user = userService.findUserById(id);
			if (null == user) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {

			log.error("Error", e);
		}
		return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user) {

		log.info("Inside getAllUsers");
		try {
			return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error", e);
		}
		return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/userByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findUserByName(@PathVariable("name") String name) {
		log.info("Inside findUserByName and Name is " + name);

		try {
			if (null == name) {
				new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
			}
			List<User> users = userService.findUserByName(name);
			if (null == users || users.isEmpty()) {
				return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (Exception e) {

			log.error("Error", e);
		}
		return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
