
package com.adressbook.service;

import com.adressbook.dto.ContactDTO;
import com.adressbook.model.Contact;
import com.adressbook.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Get all contacts
    public List<ContactDTO> getAllContacts() {
        return contactRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get contact by ID
    public ContactDTO getContactById(Integer id) {
        return contactRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Add contact
    public ContactDTO addContact(ContactDTO dto) {
        Contact contact = convertToEntity(dto);
        Contact savedContact = contactRepository.save(contact);
        return convertToDTO(savedContact);
    }

    // Convert Entity to DTO
    private ContactDTO convertToDTO(Contact contact) {
        return new ContactDTO(
                contact.getId(),
                contact.getName(),
                contact.getPhoneNumber(),
                contact.getEmail(),
                contact.getAddress()
        );
    }

    // Convert DTO to Entity
    private Contact convertToEntity(ContactDTO dto) {
        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setEmail(dto.getEmail());
        contact.setAddress(dto.getAddress());
        return contact;
    }


    public ContactDTO updateContact(Integer id, ContactDTO dto) {
        return contactRepository.findById(id)
                .map(contact -> {
                    contact.setName(dto.getName());
                    contact.setPhoneNumber(dto.getPhoneNumber());
                    contact.setEmail(dto.getEmail());
                    contact.setAddress(dto.getAddress());

                    Contact updated = contactRepository.save(contact);
                    return convertToDTO(updated);
                })
                .orElse(null);
    }

    public boolean deleteContact(Integer id) {
        if (!contactRepository.existsById(id)) {
            return false;
        }

        contactRepository.deleteById(id);
        return true;
    }

}
