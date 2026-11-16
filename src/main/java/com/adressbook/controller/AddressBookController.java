
package com.adressbook.controller;

import com.adressbook.dto.ContactDTO;
import com.adressbook.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class AddressBookController {

    private final ContactService contactService;

    public AddressBookController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Get all contacts
    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    // Get contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Integer id) {
        ContactDTO contact = contactService.getContactById(id);

        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }

    // Add contact
    @PostMapping
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO dto) {
        ContactDTO savedContact = contactService.addContact(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedContact);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(
            @PathVariable Integer id,
            @RequestBody ContactDTO dto) {

        ContactDTO updated = contactService.updateContact(id, dto);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Integer id) {

        boolean deleted = contactService.deleteContact(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
