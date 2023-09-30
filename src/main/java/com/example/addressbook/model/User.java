package com.example.addressbook.model;


import com.example.addressbook.dto.AddressBookDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    private String fName;
    private String lName;
    private String email;
    private long phoneNumber;
    private String city;
    private String state;
    private Long zipcode;

    public User(AddressBookDto addressBookDto) {  //save
        this.fName = addressBookDto.fName;
        this.lName = addressBookDto.lName;
        this.email = addressBookDto.email;
        this.phoneNumber = addressBookDto.phoneNumber;
        this.city = addressBookDto.city;
        this.state = addressBookDto.state;
        this.zipcode = addressBookDto.zipcode;
    }

    public User(int id, AddressBookDto addressBookDto) {  //update
        this.id = id;
        this.fName = addressBookDto.fName;
        this.lName = addressBookDto.lName;
        this.email = addressBookDto.email;
        this.phoneNumber = addressBookDto.phoneNumber;
        this.city = addressBookDto.city;
        this.state = addressBookDto.state;
        this.zipcode = addressBookDto.zipcode;
    }

    //    public AddressBook(AddressBookDto addressBookDto ) {  //save
//
//        this.number =addressBookDto.number;
//        this.name = addressBookDto.name;
//        this.profilePic = addressBookDto.profilePic;
//        this.price = addressBookDto.price;
//    }
//    public AddressBook( int bookId,AddressBookDto addressBookDto) {  //update
//        this.bookId = bookId;
//        this.number = addressBookDto.number;
//        this.name = addressBookDto.name;
//        this.profilePic = addressBookDto.profilePic;
//        this.price = addressBookDto.price;
//    }

}
