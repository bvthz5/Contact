package com.innovaturelabs.training.contacts.service;

import java.util.Collection;

import com.innovaturelabs.training.contacts.exception.NotFoundException;
import com.innovaturelabs.training.contacts.form.ItemForm;

import com.innovaturelabs.training.contacts.view.ItemDetailView;
import com.innovaturelabs.training.contacts.view.ItemListView;

public interface ItemService {
		
    Collection<ItemListView> list();
    
     ItemDetailView add(ItemForm form);
     
     ItemDetailView get(Integer itemId) throws NotFoundException;
     
     ItemDetailView update(Integer itemId,ItemForm form)throws NotFoundException;
     
     void delete(Integer itemId) throws NotFoundException;
}