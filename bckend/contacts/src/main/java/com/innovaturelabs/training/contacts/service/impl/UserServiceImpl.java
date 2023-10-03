/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.service.impl;

import com.innovaturelabs.training.contacts.entity.User;
import com.innovaturelabs.training.contacts.exception.BadRequestException;
import com.innovaturelabs.training.contacts.exception.NotFoundException;
import com.innovaturelabs.training.contacts.form.LoginForm;
import com.innovaturelabs.training.contacts.form.UserForm;
import com.innovaturelabs.training.contacts.repository.ContactRepository;
import com.innovaturelabs.training.contacts.repository.UserRepository;
import static com.innovaturelabs.training.contacts.security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;
import com.innovaturelabs.training.contacts.security.config.SecurityConfig;
import com.innovaturelabs.training.contacts.security.util.InvalidTokenException;
import com.innovaturelabs.training.contacts.security.util.SecurityUtil;
import com.innovaturelabs.training.contacts.security.util.TokenExpiredException;
import com.innovaturelabs.training.contacts.security.util.TokenGenerator;
import com.innovaturelabs.training.contacts.security.util.TokenGenerator.Status;
import com.innovaturelabs.training.contacts.security.util.TokenGenerator.Token;
import com.innovaturelabs.training.contacts.service.UserService;
import com.innovaturelabs.training.contacts.view.LoginView;
import com.innovaturelabs.training.contacts.view.UserView;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

/**
 *
 * @author nirmal
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;


    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public UserView add(UserForm form) {
        return new UserView(userRepository.save(new User(
                form.getName(),
                form.getEmail(),
                passwordEncoder.encode(form.getPassword())
        )));
    }



    @Override
    @Transactional
    public UserView update(Integer userId, UserForm form) throws NotFoundException {

        User user=userRepository.findById(userId).orElseThrow(NotFoundException::new);
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        userRepository.save(user);
        return new UserView(user);

    }
        //return userRepository.findByContactIdAndUserUserId(userId, SecurityUtil.getCurrentUserId())
              //  .map((user) -> {
               //     return new UserView(userRepository.save(user.update(form)));
            //    }).orElseThrow(NotFoundException::new);

    @Override
    @Transactional
    public void delete(Integer userId) throws NotFoundException {

        contactRepository.deleteByUserUserId(userId);

        userRepository.deleteById(userId);        
        
    }
    
    @Override
    public UserView currentUser() {
        return new UserView(
                userRepository.findById(SecurityUtil.getCurrentUserId()).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public LoginView login(LoginForm form, Errors errors) throws BadRequestException {
        if (errors.hasErrors()) {
            throw badRequestException();
        }
        User user = userRepository.findByEmail(form.getEmail()).orElseThrow(UserServiceImpl::badRequestException);
        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw badRequestException();
        }

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + user.getPassword(), securityConfig.getRefreshTokenExpiry());
        return new LoginView(user, accessToken, refreshToken);
    }

    @Override
    public LoginView refresh(String refreshToken) throws BadRequestException {
        Status status;
        try {
            status = tokenGenerator.verify(PURPOSE_REFRESH_TOKEN, refreshToken);
        } catch (InvalidTokenException e) {
            throw new BadRequestException("Invalid token", e);
        } catch (TokenExpiredException e) {
            throw new BadRequestException("Token expired", e);
        }

        int userId;
        try {
            userId = Integer.parseInt(status.data.substring(0, 10));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid token", e);
        }

        String password = status.data.substring(10);

        User user = userRepository.findByUserIdAndPassword(userId, password).orElseThrow(UserServiceImpl::badRequestException);

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        return new LoginView(
                user,
                new LoginView.TokenView(accessToken.value, accessToken.expiry),
                new LoginView.TokenView(refreshToken, status.expiry)
        );
    }

    private static BadRequestException badRequestException() {
        return new BadRequestException("Invalid credentials");
    }

   
    @Override
    public Collection<User> list() {
        return userRepository.findAll();
    }


    @Override
    public UserView get(Integer userId) throws NotFoundException {
        return userRepository.findById(userId)
        .map((user) -> {
            return new UserView(user);
        }).orElseThrow(NotFoundException::new);

        }
/////////////////////////////////////////////////////

    /**
     * @param userId
     * @param form
     * @return
     */
   
}
