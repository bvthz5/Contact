/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.entity;

import com.innovaturelabs.training.contacts.form.ContactForm;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nirmal
 */
@Entity
public class Contact {

    public static enum Status {
        DELETED((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;
    private String firstName;
    private String lastName;
    private String nickName;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private byte status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @ElementCollection(fetch = FetchType.LAZY)
    private Collection<String> phone;
    @ElementCollection(fetch = FetchType.LAZY)
    private Collection<String> email;

    public Contact() {
    }

    public Contact(Integer contactId) {
        this.contactId = contactId;
    }

    public Contact(ContactForm form, Integer userId) {
        this.user = new User(userId);

        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.nickName = form.getNickName();
        this.dob = form.getDob();
        this.address = form.getAddress();
        this.city = form.getCity();
        this.state = form.getState();
        this.country = form.getCountry();
        this.zipCode = form.getZipCode();

        this.phone = form.getPhones();
        this.email = form.getEmails();

        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public Contact update(ContactForm form) {
        this.firstName = form.getFirstName();
        this.lastName = form.getLastName();
        this.nickName = form.getNickName();
        this.dob = form.getDob();
        this.address = form.getAddress();
        this.city = form.getCity();
        this.state = form.getState();
        this.country = form.getCountry();
        this.zipCode = form.getZipCode();

        this.phone = form.getPhones();
        this.email = form.getEmails();

        Date dt = new Date();
        this.updateDate = dt;

        return this;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<String> getPhone() {
        return phone;
    }

    public void setPhone(Collection<String> phone) {
        this.phone = phone;
    }

    public Collection<String> getEmail() {
        return email;
    }

    public void setEmail(Collection<String> email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Contact)) {
            return false;
        }
        return Objects.equals(contactId, ((Contact) object).contactId);
    }

    @Override
    public String toString() {
        return "com.innovaturelabs.training.contacts.entity.Contact[ contactId=" + contactId + " ]";
    }
}
