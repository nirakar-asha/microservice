package com.minibank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold account information"
)
@Data
public class AccountsDto {

    @Schema(
            description = "Account number of the customer",
            example = "1234567890"
    )
    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the customer",
            example = "Saving"
    )
    @NotEmpty(message = "Account type can not be a null or empty")
    private String accountType;

    @Schema(
            description = "Account branch address of the customer",
            example = "123, Street"
    )
    @NotEmpty(message = "Branch address can not be a null or empty")
    private String branchAddress;
}
