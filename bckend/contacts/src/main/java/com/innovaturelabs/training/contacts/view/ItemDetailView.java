package com.innovaturelabs.training.contacts.view;

import com.innovaturelabs.training.contacts.entity.Item;

public class ItemDetailView extends ItemListView {
	public ItemDetailView(Item item) {
		super(
				item.getItemId(),
				item.getName(),
				item.getDescription(),
				item.getType(),
				item.getCreateDate(),
				item.getUpdateDate()
				);
	}
}