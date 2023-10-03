/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.service;

import com.innovaturelabs.training.contacts.exception.NotFoundException;
import com.innovaturelabs.training.contacts.form.ContactForm;
import com.innovaturelabs.training.contacts.view.ContactDetailView;
import com.innovaturelabs.training.contacts.view.ContactListView;
import java.util.Collection;

/**
 *
 * @author nirmal
 */
public interface ContactService {

    // Collection<ContactListView> list(Integer pageno, Integer pagesize, String sortBy, String sortDir);
    Collection<ContactListView> list();

    ContactDetailView add(ContactForm form);

    ContactDetailView get(Integer contactId) throws NotFoundException;

    ContactDetailView update(Integer contactId, ContactForm form) throws NotFoundException;

    void delete(Integer contactId) throws NotFoundException;
}
