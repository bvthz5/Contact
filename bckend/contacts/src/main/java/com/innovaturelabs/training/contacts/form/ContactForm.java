/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.contacts.form;

import com.innovaturelabs.training.contacts.json.Json;
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author nirmal
 */
public class ContactForm {

    @Size(max = 30)
    @NotBlank
    private String firstName;
    @Size(max = 30)
    private String lastName;
    @Size(max = 30)
    private String nickName;
    @Json.DateFormat
    private Date dob;
    @Size(max = 200)
    private String address;
    @Size(max = 50)
    private String city;
    @Size(max = 50)
    private String state;
    @Size(max = 50)
    private String country;
    @Size(max = 8)
    @Pattern(regexp = "^(\\d+[ -]?)*\\d$")
    private String zipCode;
    @NotNull
    private Collection<@NotBlank @Size(max = 20) @Pattern(regexp = "^\\+?(\\d+ ?)*\\d$") String> phones;
    @NotNull
    private Collection<@NotBlank @Size(max = 255) @Email String> emails;

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

    public Collection<String> getPhones() {
        return phones;
    }

    public void setPhones(Collection<String> phones) {
        this.phones = phones;
    }

    public Collection<String> getEmails() {
        return emails;
    }

    public void setEmails(Collection<String> emails) {
        this.emails = emails;
    }
}
