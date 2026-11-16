
package com.adressbook.controller;

import com.adressbook.model.Contact;
import com.adressbook.repository.ContactRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class AddressBookController {

    private final ContactRepository contactRepository;

    public AddressBookController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // GET all contacts
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactRepository.findAll());
    }

    // GET contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {
        return contactRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST new contact
    @PostMapping
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        Contact savedContact = contactRepository.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }

    // PUT update contact
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(
            @PathVariable int id,
            @RequestBody Contact updatedContact) {

        return contactRepository.findById(id)
                .map(contact -> {
                    contact.setName(updatedContact.getName());
                    contact.setPhoneNumber(updatedContact.getPhoneNumber());
                    contact.setEmail(updatedContact.getEmail());
                    contact.setAddress(updatedContact.getAddress());

                    Contact savedContact = contactRepository.save(contact);
                    return ResponseEntity.ok(savedContact);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE contact
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {

        if (!contactRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        contactRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
