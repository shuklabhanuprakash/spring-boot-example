/**
 * 
 */
package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.BaseDao;
import com.practice.model.User;
import com.practice.service.UserService;

/**
 * @author miles20
 *
 */
@Service
public class UserServiceImpl implements UserService {

	
	/*@Autowired
	public CrudRepository<User, Integer> crudDao;
	*/
	
	@Autowired
    BaseDao baseDao;
	
	@Override
	public List<User> getAllUsers() {
		
		return (List<User>) baseDao.findAll();
	}

}
