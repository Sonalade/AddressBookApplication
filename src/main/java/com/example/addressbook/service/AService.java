package com.example.addressbook.service;

import com.example.addressbook.model.User;

import java.util.List;

public interface AService {

    public List<User> getAllAddressBook();
    public User saveData(User addressBook);
}
