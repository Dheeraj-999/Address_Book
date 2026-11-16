
package com.adressbook.service;

import com.adressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service
public class AddressBookService {

    private final Map<String, AddressBook> addressBooks = new LinkedHashMap<>();

    public AddressBook createAddressBook(String name) {

        if (addressBooks.containsKey(name)) {
            return null;
        }

        AddressBook addressBook = new AddressBook(name);
        addressBooks.put(name, addressBook);

        return addressBook;
    }

    public List<AddressBook> getAllAddressBooks() {
        return new ArrayList<>(addressBooks.values());
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }
}
