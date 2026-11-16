
package com.adressbook.service;

import com.adressbook.dto.ContactDTO;
import com.adressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final AddressBookService addressBookService;

    private Integer nextId = 1;

    public ContactService(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    public List<ContactDTO> getAllContacts(String addressBookName) {

        AddressBook addressBook =
                addressBookService.getAddressBook(addressBookName);

        if (addressBook == null) {
            return null;
        }

        return addressBook.getContacts();
    }

    public ContactDTO getContactById(String addressBookName, Integer id) {

        List<ContactDTO> contacts = getAllContacts(addressBookName);

        if (contacts == null) {
            return null;
        }

        return contacts.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public ContactDTO addContact(String addressBookName, ContactDTO dto) {

        AddressBook addressBook =
                addressBookService.getAddressBook(addressBookName);

        if (addressBook == null) {
            return null;
        }

        // Check for duplicate contact name
        boolean duplicateExists = addressBook.getContacts()
                .stream()
                .anyMatch(contact ->
                        contact.getName().equalsIgnoreCase(dto.getName()));

        if (duplicateExists) {
            return null;
        }

        dto.setId(nextId++);
        addressBook.getContacts().add(dto);

        return dto;
    }

    public ContactDTO updateContact(String addressBookName, Integer id,
                                    ContactDTO dto) {

        ContactDTO existing = getContactById(addressBookName, id);

        if (existing == null) {
            return null;
        }

        existing.setName(dto.getName());
        existing.setPhoneNumber(dto.getPhoneNumber());
        existing.setEmail(dto.getEmail());
        existing.setAddress(dto.getAddress());

        return existing;
    }

    public boolean deleteContact(String addressBookName, Integer id) {

        AddressBook addressBook =
                addressBookService.getAddressBook(addressBookName);

        if (addressBook == null) {
            return false;
        }

        ContactDTO contact = getContactById(addressBookName, id);

        if (contact == null) {
            return false;
        }

        return addressBook.getContacts().remove(contact);
    }
}
