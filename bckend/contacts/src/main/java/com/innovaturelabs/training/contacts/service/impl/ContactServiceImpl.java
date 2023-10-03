/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.service.impl;

import com.innovaturelabs.training.contacts.entity.Contact;
import com.innovaturelabs.training.contacts.exception.NotFoundException;
import com.innovaturelabs.training.contacts.form.ContactForm;
import com.innovaturelabs.training.contacts.repository.ContactRepository;
import com.innovaturelabs.training.contacts.security.util.SecurityUtil;
import com.innovaturelabs.training.contacts.service.ContactService;
import com.innovaturelabs.training.contacts.view.ContactDetailView;
import com.innovaturelabs.training.contacts.view.ContactListView;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author nirmal
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Collection<ContactListView> list() {
        return contactRepository.findAllByUserUserIdAndStatus(SecurityUtil.getCurrentUserId(),Contact.Status.ACTIVE.value);
    }
	
    // public Collection<ContactListView> list(Integer pageNo, Integer pageSize, String sortBy, String sortDir) {
    //     Sort sort = sortDir.equalsIgnoreCase(Direction.ASC.name()) ? Sort.by(sortBy).ascending()
    //     : Sort.by(sortBy).descending();

    //     Pageable page = PageRequest.of(pageNo, pageSize, sort);

    //     return contactRepository.findAllByUserUserIdAndStatus(SecurityUtil.getCurrentUserId(),Contact.Status.ACTIVE.value, sort, page);
    // }
    /////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public ContactDetailView add(ContactForm form) {
        return new ContactDetailView(contactRepository.save(new Contact(form, SecurityUtil.getCurrentUserId())));
    }

    @Override
    public ContactDetailView get(Integer contactId) throws NotFoundException {
        return contactRepository.findByContactIdAndUserUserIdAndStatus(contactId, SecurityUtil.getCurrentUserId(),Contact.Status.ACTIVE.value)
        .map((contact) -> {
            return new ContactDetailView(contact);
        }).orElseThrow(NotFoundException::new);

        }
           
    

    @Override
    @Transactional
    public ContactDetailView update(Integer contactId, ContactForm form) throws NotFoundException {
        return contactRepository.findByContactIdAndUserUserIdAndStatus(contactId, SecurityUtil.getCurrentUserId(),Contact.Status.ACTIVE.value)
        .map((contact ) -> {
                    return new ContactDetailView(contactRepository.save(contact.update(form)));
                }).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public void delete(Integer contactId) throws NotFoundException {
        contactRepository.deleteContacts(contactId);
    }

    @Override
    public Collection<ContactListView> list(Integer pageno, Integer pagesize, String sortBy, String sortDir) {
        // TODO Auto-generated method stub
        return null;
    }
}
