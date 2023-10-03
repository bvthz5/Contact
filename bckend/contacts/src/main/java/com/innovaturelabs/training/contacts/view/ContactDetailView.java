/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.view;

import com.innovaturelabs.training.contacts.entity.Contact;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author nirmal
 */
public class ContactDetailView extends ContactListView {

    private final Collection<String> phones;
    private final Collection<String> emails;

    public ContactDetailView(Contact contact) {
        super(
                contact.getContactId(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getNickName(),
                contact.getDob(),
                contact.getAddress(),
                contact.getCity(),
                contact.getState(),
                contact.getCountry(),
                contact.getZipCode(),
                contact.getStatus(),
                contact.getCreateDate(),
                contact.getUpdateDate()
        );
        this.phones = Collections.unmodifiableCollection(contact.getPhone());
        this.emails = Collections.unmodifiableCollection(contact.getEmail());
    }

    public Collection<String> getPhones() {
        return phones;
    }

    public Collection<String> getEmails() {
        return emails;
    }

    

   
    
}
