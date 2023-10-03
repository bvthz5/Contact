/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.view;

import com.innovaturelabs.training.contacts.json.Json;
import java.util.Date;

/**
 *
 * @author nirmal
 */
public class ContactListView {

    private final int contactId;
    private final String firstName;
    private final String lastName;
    private final String nickName;
    @Json.DateFormat
    private final Date dob;
    private final String address;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;
    private final byte status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;

    public ContactListView(int contactId, String firstName, String lastName, String nickName, Date dob, String address, String city, String state, String country, String zipCode, byte status, Date createDate, Date updateDate) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public byte getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}
