package com.minibank.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max=30, message = "The length of the customer name should be between 5 and 30 char")
    private String name;

    @NotEmpty(message = "Email Id can not be a null or empty")
    @Email(message = "Email id should be valid value")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
