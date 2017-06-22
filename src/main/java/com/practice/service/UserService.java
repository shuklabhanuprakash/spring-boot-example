/**
 * 
 */
package com.practice.service;

import java.util.List;

import com.practice.model.User;

/**
 * @author miles20
 *
 */
public interface UserService {

	List<User> getAllUsers();

	User findUserById(Integer id);

	User save(User user);

	List<User> findUserByName(String name);
	
	

}
