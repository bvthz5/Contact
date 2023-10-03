/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.controller;

import com.innovaturelabs.training.contacts.form.ContactForm;
import com.innovaturelabs.training.contacts.service.ContactService;
import com.innovaturelabs.training.contacts.view.ContactDetailView;
import com.innovaturelabs.training.contacts.view.ContactListView;



import java.security.Principal;
import java.util.Collection;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nirmal
 */
@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public Collection<ContactListView> list(Principal p) {
        return contactService.list();
    }
    // @GetMapping("/{pageno}/{pagesize}")
    // public Collection<ContactListView> list(Principal p,@RequestParam Integer pageNo,@RequestParam Integer pageSize,@RequestParam String sortBy, @RequestParam String sortDir) {
    //     return contactService.list(pageNo, pageSize, sortBy,  sortDir);
    // }

    @PostMapping
    public ContactDetailView add(@Valid @RequestBody ContactForm form) {
        return contactService.add(form);
    }

    @GetMapping("/{contactId}")
    public ContactDetailView get(@PathVariable("contactId") Integer contactId) {
        return contactService.get(contactId);
    }

    @PutMapping("/{contactId}")
    public ContactDetailView update(
            @PathVariable("contactId") Integer contactId,
            @Valid @RequestBody ContactForm form
    ) {
        return contactService.update(contactId, form);
    }

    @DeleteMapping("/{contactId}")
    public void delete(@PathVariable("contactId") Integer contactId) {
        contactService.delete(contactId);
    }

}
