package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.model.User;
import com.example.addressbook.repository.ABRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ABService {


    private List<User> addressBooklist=new ArrayList<>();

    @Autowired
    ABRepo abRepo;

    public User addAddressBookDto(AddressBookDto addressBookDto) {
        User addressBook = new User(addressBookDto);
        addressBooklist.add(addressBook);
        return abRepo.save(addressBook);
    }

    public User getAddressBook(int id){
        return abRepo.findById(id).orElse(null);
    }

    public String deleteAddressBook(int id) {
        abRepo.deleteById(id);
        return "deleted successfully";
    }

    public User updateAddressBook(@NotNull AddressBookDto ab, int id){
        User abobject = new User(ab);
        abobject.setId(id);
        return abRepo.save(abobject);
    }
    public List<User> getAllAddressBook() {
        return abRepo.findAll();
    }

    public List<User> getUserByCity(String city){
        return abRepo.findByCity(city);
    }

}
