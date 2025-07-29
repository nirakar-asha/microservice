package com.minibank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "Customer",
        description = "Schema to hold customer and account information"
)
@Data
public class CustomerDto {

    @Schema(
            description = "Name of the customer",
            example = "Nirakar Asha"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max=30, message = "The length of the customer name should be between 5 and 30 char")
    private String name;

    @Schema(
            description = "Email address of the customer",
            example = "nirakarasha@gmail.com"
    )
    @NotEmpty(message = "Email Id can not be a null or empty")
    @Email(message = "Email id should be valid value")
    private String email;

    @Schema(
            description = "Phone number of the customer",
            example = "9087654321"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Accounts detail of the customer"
    )
    private AccountsDto accountsDto;
}
