package com.example.addressbook.repository;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ABRepo extends JpaRepository<User,Integer> {
    List<User> findByCity(String City);

}
