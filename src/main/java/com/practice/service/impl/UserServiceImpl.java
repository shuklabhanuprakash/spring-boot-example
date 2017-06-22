/**
 * 
 */
package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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

	
	@Autowired
	public CrudRepository<User, Integer> crudDao;
	
	
	@Autowired
    BaseDao baseDao;
	
	@Override
	public List<User> getAllUsers() {
		
		return (List<User>) crudDao.findAll();
	}


	@Override
	public User findUserById(Integer id) {
		return crudDao.findOne(id);
	}


	@Override
	public User save(User user) {
		return crudDao.save(user);
	}


	@Override
	public List<User> findUserByName(String name) {
		// TODO Auto-generated method stub
		//return crudDao.findOne(name);
		return baseDao.findByName(name);
	}

	
	
	
	
}
