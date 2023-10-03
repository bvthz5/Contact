/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.controller;

import com.innovaturelabs.training.contacts.entity.User;
import com.innovaturelabs.training.contacts.form.UserForm;
import com.innovaturelabs.training.contacts.security.util.SecurityUtil;
import com.innovaturelabs.training.contacts.service.UserService;
import com.innovaturelabs.training.contacts.view.UserView;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author nirmal
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserView add(@Valid @RequestBody UserForm form) {
        return userService.add(form);
    }

    @GetMapping
    public Collection<User> list() {
        return userService.list();
    }

    @GetMapping("/{userId}")
    public UserView get(@PathVariable("userId") Integer userId) {
        return userService.get(userId);
    }



    @PutMapping()
    public UserView edit(
            
            @Valid @RequestBody UserForm form
    ) {
        return userService.update(SecurityUtil.getCurrentUserId(), form);
    }

    @PutMapping("/{userId}")
    public UserView update(
            @PathVariable("userId") Integer userId,
            @Valid @RequestBody UserForm form
    ) {
        return userService.update(userId, form);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
    }

}
