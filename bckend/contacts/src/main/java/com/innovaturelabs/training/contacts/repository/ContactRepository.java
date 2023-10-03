/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.repository;

import com.innovaturelabs.training.contacts.entity.Contact;

import com.innovaturelabs.training.contacts.view.ContactListView;
import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author nirmal
 */
public interface ContactRepository extends Repository<Contact, Integer> {

    Collection<ContactListView> findAllByUserUserId(Integer userId);

    Optional<Contact>findByContactIdAndUserUserIdAndStatus(Integer contactId, Integer userId,Byte status);

    Contact save(Contact contact);

    // void delete(Contact contact);

@Modifying
@Transactional
@Query(value = "UPDATE contact SET status=0 where contact_id =:contactId", nativeQuery = true)
public void deleteContacts(@Param("contactId") Integer contactId);
void deleteByUserUserId(Integer userId);

 Collection<ContactListView> findAllByUserUserIdAndStatus(Integer currentUserId, byte value);

    

   
}
