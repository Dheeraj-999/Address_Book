
package com.adressbook.model;

import com.adressbook.dto.ContactDTO;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private String name;
    private List<ContactDTO> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }
}
