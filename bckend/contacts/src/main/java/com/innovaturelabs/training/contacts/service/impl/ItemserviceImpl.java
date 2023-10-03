package com.innovaturelabs.training.contacts.service.impl;

import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innovaturelabs.training.contacts.entity.Item;
import com.innovaturelabs.training.contacts.exception.NotFoundException;
import com.innovaturelabs.training.contacts.form.ItemForm;
import com.innovaturelabs.training.contacts.repository.ItemRepository;
import com.innovaturelabs.training.contacts.security.util.SecurityUtil;
import com.innovaturelabs.training.contacts.service.ItemService;
import com.innovaturelabs.training.contacts.view.ItemDetailView;
import com.innovaturelabs.training.contacts.view.ItemListView;

@Service
public class ItemserviceImpl implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	@Override
    public Collection<ItemListView> list() {
        return itemRepository.findAllByUserUserIdAndStatus(SecurityUtil.getCurrentUserId(),Item.Status.ACTIVE.value);
    }
	
	@Override
    public ItemDetailView add(ItemForm form) {
        return new ItemDetailView(itemRepository.save(new Item(form, SecurityUtil.getCurrentUserId())));
    }
	
	
	@Override
	public ItemDetailView get(Integer itemId)throws NotFoundException{
		return itemRepository.findByItemIdAndUserUserIdAndStatus(itemId,SecurityUtil.getCurrentUserId(),Item.Status.ACTIVE.value)
				.map((item)->{
					return new ItemDetailView(item);
				}).orElseThrow(NotFoundException::new);
	}
	
	@Override
	@Transactional
	public ItemDetailView update(Integer itemId,ItemForm form)throws NotFoundException{
		return itemRepository.findByItemIdAndUserUserIdAndStatus(itemId, SecurityUtil.getCurrentUserId(),Item.Status.ACTIVE.value)
				.map((item)->{
					return new ItemDetailView(itemRepository.save(item.update(form)));
				}).orElseThrow(NotFoundException::new);
				}
	
	@Override
	@Transactional
	public void delete(Integer itemId) throws NotFoundException {
        itemRepository.deleteItems(itemId);
    }

    
}