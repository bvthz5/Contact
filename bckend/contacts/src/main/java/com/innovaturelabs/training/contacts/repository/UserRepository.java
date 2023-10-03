/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.repository;

import com.innovaturelabs.training.contacts.entity.User;
import java.util.Collection;
import java.util.Optional;


import org.springframework.data.repository.Repository;


/**
 *
 * @author nirmal
 */
public interface UserRepository extends Repository<User, Integer> {

    Optional<User> findById(Integer userId);

    Optional<User> findByUserIdAndPassword(Integer userId, String password);

    Optional<User> findByEmail(String email);
    // Optional<User>findByuserId(Integer userId);

    User save(User user);

    // @Modifying
	// @Transactional
	// @Query(value = "update user set status=0 where user_id=:userId",nativeQuery = true)
	// public void deleteUser(@Param("userId")Integer userId);
    
    void delete(User contact);

    void deleteById(Integer userId);
    
    Collection<User> findAll();

    

    

    //Optional<User> findByContactIdAndUserUserId(Integer userId, Integer currentUserId);
}
