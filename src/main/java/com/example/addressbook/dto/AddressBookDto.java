package com.example.addressbook.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
public class AddressBookDto {
    @NotEmpty(message="fName cannot be null")
    public String fName;
    @NotEmpty(message="lName cannot be null")
    public String lName;
    @NotEmpty(message="email cannot be null")
    public String email;
    @NotEmpty(message="phoneNumber cannot be null")
    public long phoneNumber;
    @NotEmpty(message="city cannot be null")
    public String city;
    @NotEmpty(message="state cannot be null")
    public String state;
    @NotEmpty(message="zipcode cannot be null")
    public long zipcode;


//    @NotEmpty(message = "number cannot be empty")
//    public int number;
//
//    @NotBlank(message = "profile pic not be empty")
//    public String profilePic;
//
//    @Min(value = 200,message = "minimum price should be more than 200")
//    public long price;

//       @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "AddressBook name Invalid")
//       @JsonFormat(pattern = "dd mm yyyy")
//    @NotEmpty(message = "start date should be not empty")
//    public String startDate;
//    @Pattern(regexp = "male|female",message = "gender needs to be male or female")
//    public String gender;
//
//    @NotBlank(message = "note cannot be empty")
//    public String note;
//    @NotBlank(message = "department not be empty")
//    public String department;


}
