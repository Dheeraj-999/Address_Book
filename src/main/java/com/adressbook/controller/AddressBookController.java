
package com.adressbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @GetMapping("/hello")
    public String hello() {
        return "Welcome to Address Book Application!";
    }
}
