
package com.adressbook.controller;

import com.adressbook.dto.ContactDTO;
import com.adressbook.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressbooks/{addressBookName}/contacts")
public class AddressBookController {

    private final ContactService contactService;

    public AddressBookController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<?> getAllContacts(
            @PathVariable String addressBookName) {

        List<ContactDTO> contacts =
                contactService.getAllContacts(addressBookName);

        if (contacts == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(
            @PathVariable String addressBookName,
            @PathVariable Integer id) {

        ContactDTO contact =
                contactService.getContactById(addressBookName, id);

        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }


    @PostMapping
    public ResponseEntity<?> addContact(
            @PathVariable String addressBookName,
            @RequestBody ContactDTO dto) {

        // Check whether Address Book exists
        List<ContactDTO> contacts =
                contactService.getAllContacts(addressBookName);

        if (contacts == null) {
            return ResponseEntity.notFound().build();
        }

        // Check duplicate contact name
        boolean duplicateExists = contacts.stream()
                .anyMatch(contact ->
                        contact.getName().equalsIgnoreCase(dto.getName()));

        if (duplicateExists) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Contact already exists in this Address Book");
        }

        ContactDTO contact =
                contactService.addContact(addressBookName, dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateContact(
            @PathVariable String addressBookName,
            @PathVariable Integer id,
            @RequestBody ContactDTO dto) {

        ContactDTO contact =
                contactService.updateContact(addressBookName, id, dto);

        if (contact == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(
            @PathVariable String addressBookName,
            @PathVariable Integer id) {

        boolean deleted =
                contactService.deleteContact(addressBookName, id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
