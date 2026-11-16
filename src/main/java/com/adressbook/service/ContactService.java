
package com.adressbook.service;

import com.adressbook.dto.ContactDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final List<ContactDTO> contacts = new ArrayList<>();
    private Integer nextId = 1;

    // Get all contacts
    public List<ContactDTO> getAllContacts() {
        return contacts;
    }

    // Get contact by ID
    public ContactDTO getContactById(Integer id) {
        return contacts.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add contact
    public ContactDTO addContact(ContactDTO dto) {
        dto.setId(nextId++);
        contacts.add(dto);
        return dto;
    }

    // Update contact
    public ContactDTO updateContact(Integer id, ContactDTO dto) {
        ContactDTO existing = getContactById(id);

        if (existing == null) {
            return null;
        }

        existing.setName(dto.getName());
        existing.setPhoneNumber(dto.getPhoneNumber());
        existing.setEmail(dto.getEmail());
        existing.setAddress(dto.getAddress());

        return existing;
    }

    // Delete contact
    public boolean deleteContact(Integer id) {
        ContactDTO contact = getContactById(id);

        if (contact == null) {
            return false;
        }

        contacts.remove(contact);
        return true;
    }
}
