package com.minibank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        name = "Response",
        description = "Schema to hold the response"
)
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status code of response"
    )
    private String statusCode;

    @Schema(
            description = "Status message of response"
    )
    private String statusMessage;
}
