package com.innovaturelabs.training.contacts.repository;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import com.innovaturelabs.training.contacts.entity.Item;
import com.innovaturelabs.training.contacts.view.ItemListView;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends Repository<Item, Integer> {
	
	Collection<ItemListView> findAllByUserUserId(Integer userId);
	
	Optional<Item>findByItemIdAndUserUserId(Integer itemId,Integer userId);
	
	Item save(Item item);
	
	// void delete(Item item);

	@Modifying
	@Transactional
	@Query(value = "update item set status=0 where item_id=:itemId",nativeQuery = true)
	public void deleteItems(@Param("itemId")Integer itemId);

	
	void deleteByUserUserId(Integer userId);

	Collection<ItemListView> findAllByUserUserIdAndStatus(Integer currentUserId, byte value);

    Optional<Item> findByItemIdAndUserUserIdAndStatus(Integer item_id, Integer currentUserId, byte value);

    

	

}