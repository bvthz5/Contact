
package com.innovaturelabs.training.contacts.service;

import com.innovaturelabs.training.contacts.entity.User;
import com.innovaturelabs.training.contacts.exception.BadRequestException;
import com.innovaturelabs.training.contacts.exception.NotFoundException;
import com.innovaturelabs.training.contacts.form.LoginForm;
import com.innovaturelabs.training.contacts.form.UserForm;
import com.innovaturelabs.training.contacts.view.LoginView;
import com.innovaturelabs.training.contacts.view.UserView;
import java.util.Collection;
import org.springframework.validation.Errors;

/**
 *
 * @author nirmal
 */
public interface UserService {

    UserView add(UserForm form);

    UserView get(Integer userId) throws NotFoundException;

    UserView update(Integer userId, UserForm form) throws NotFoundException;
    void delete(Integer userId) throws NotFoundException;

    UserView currentUser();

    LoginView login(LoginForm form, Errors errors) throws BadRequestException;

    LoginView refresh(String refreshToken) throws BadRequestException;

    Collection<User> list();
}
