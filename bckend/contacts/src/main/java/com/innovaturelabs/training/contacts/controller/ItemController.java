package com.innovaturelabs.training.contacts.controller;

import java.security.Principal;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.innovaturelabs.training.contacts.form.ItemForm;
import com.innovaturelabs.training.contacts.service.ItemService;
import com.innovaturelabs.training.contacts.view.ItemDetailView;
import com.innovaturelabs.training.contacts.view.ItemListView;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public Collection<ItemListView> list(Principal p){
		return itemService.list();
	}
	
	@PostMapping
	public ItemDetailView add(@Valid @RequestBody ItemForm form ) {
		return itemService.add(form);
	}
	
	@GetMapping("/{itemId}")
	public ItemDetailView get(@PathVariable("itemId") Integer itemId) {
		return itemService.get(itemId);
	}
	
	@PutMapping("/{itemId}")
	public  ItemDetailView update(@PathVariable("itemId") Integer itemId,
			@Valid @RequestBody ItemForm form)
	{
		return itemService.update(itemId,form);
	}
	
	@DeleteMapping("/{itemId}")
	public void delete(@PathVariable("itemId")Integer itemId) {
		itemService.delete(itemId);
	}
}