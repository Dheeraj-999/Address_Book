
package com.adressbook.controller;

import com.adressbook.model.AddressBook;
import com.adressbook.service.AddressBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/addressbooks")
public class AddressBookManagementController {

    private final AddressBookService addressBookService;

    public AddressBookManagementController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @PostMapping
    public ResponseEntity<?> createAddressBook(@RequestBody Map<String, String> request) {

        String name = request.get("name");

        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Address Book name is required");
        }

        AddressBook addressBook = addressBookService.createAddressBook(name.trim());

        if (addressBook == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Address Book already exists");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(addressBook);
    }

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllAddressBooks() {
        return ResponseEntity.ok(addressBookService.getAllAddressBooks());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getAddressBook(@PathVariable String name) {

        AddressBook addressBook = addressBookService.getAddressBook(name);

        if (addressBook == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(addressBook);
    }
}
