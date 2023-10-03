package com.innovaturelabs.training.contacts.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.innovaturelabs.training.contacts.form.ItemForm;

@Entity
public class Item {
	public static enum Status{
		DELETED((byte)0),
		ACTIVE((byte)1);
		public final byte value;
		private Status(byte value) {
		this.value= value;
	}
}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	private String name;
	private String description;
	private String type;
	//
	private byte status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User user;
	
	public Item() {
		
	}
	public Item(Integer itemId) {
		this.itemId=itemId;
	}
	
	public Item(ItemForm form,Integer userId) {
		this.user=new User(userId);
		this.name=form.getName();
		this.description=form.getDescription();
		this.type=form.getType();
		Date dt=new Date();
	     this.createDate = dt;
	    this.updateDate = dt;
		//
		this.status = Status.ACTIVE.value;
		
	}
	
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	//
	public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
	//
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Item update(ItemForm form) {
		this.name=form.getName();
		this.description=form.getDescription();
		this.type=form.getType();
		Date dt=new Date();
		this.updateDate=dt;
		return this;
	}

    
}