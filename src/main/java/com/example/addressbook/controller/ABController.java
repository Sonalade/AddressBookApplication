package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDto;
import com.example.addressbook.dto.ResponseDto;
import com.example.addressbook.model.User;
import com.example.addressbook.service.ABService;
import com.example.addressbook.util.Token;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ABController {

    @Autowired

    ABService abService;

    @Autowired
    Token token;

//    @PostMapping("/addAddressBookDto")
//    public ResponseEntity<ResponseDto> addAddressBookDto(@RequestBody AddressBookDto addressBookDto) {
//        User addressBook=abService.addAddressBookDto(addressBookDto);
//        ResponseDto responseDto=new ResponseDto("new employee added successfully",addressBook);
//        ResponseEntity<ResponseDto> response=new ResponseEntity<>(responseDto, HttpStatus.OK);
//        return response;
//    }



//    @GetMapping("/getAddressBook/{id}")
//    public User getAddressBook(@PathVariable int id) {
//        return abService.getAddressBook(id);
//    }



//    @DeleteMapping("/deleteAddressBook/{id}")
//    public String deleteAddressBook(@PathVariable int id) {
//        return abService.deleteAddressBook(id);
//    }



//    @PutMapping("/updateAddressBook/{id}")
//    public ResponseEntity<ResponseDto> updateAddressBook(@Valid @PathVariable int id ,@RequestBody AddressBookDto ab){
//        User addressBook = abService.updateAddressBook(ab,id);
//        ResponseDto responseDto = new ResponseDto(" AddressBook updated successfully",addressBook,null);
//        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
//        return response;
//    }

    @GetMapping("/allAddressBook")
    public List<User> getAll(){
        return abService.getAllAddressBook();
    }

    @PostMapping("/addAddressBookDto")
    public ResponseEntity<ResponseDto> addAddressBookDto(@RequestBody AddressBookDto addressBookDto) {
        User addressBook=abService.addAddressBookDto(addressBookDto);
        String token1= token.createToken(addressBook.getId());
        ResponseDto responseDto=new ResponseDto("new employee added successfully",addressBook,token1);
        ResponseEntity<ResponseDto> response=new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @GetMapping("/getAddressBook/{token1}")
    public User getAddressBook(@PathVariable String token1) {
        int UserId= token.decodeToken(token1);
        return abService.getAddressBook(UserId);
    }

    
    @PutMapping("/updateAddressBook/{token1}")
    public ResponseEntity<ResponseDto> updateAddressBook(@Valid @PathVariable String token1 ,@RequestBody AddressBookDto ab){
        int UserId= token.decodeToken(token1);
        User addressBook = abService.updateAddressBook(ab,UserId);
        ResponseDto responseDto = new ResponseDto(" AddressBook updated successfully",addressBook,null);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }



    @DeleteMapping("/deleteAddressBook/{token1}")
    public String deleteAddressBook(@PathVariable String token1) {
        int UserId= token.decodeToken(token1);
        return abService.deleteAddressBook(UserId);
    }

    @GetMapping("/getUserByCity")
    public List<User> getCityByCity(@RequestParam String city){
        return abService.getUserByCity(city);
    }

}
