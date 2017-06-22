/**
 * 
 */
package com.practice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.User;

/**
 * @author miles20
 *
 */

@Repository
public interface BaseDao extends CrudRepository<User, Integer> {

	List<User> findByName(String name);
	
}
