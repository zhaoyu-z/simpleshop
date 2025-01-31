package com.iamzzy.simpleshop.controller.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Jacksonized
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseBody {
    private String message;
    private Object data;

    public static ResponseEntity<ResponseBody> withMessage(HttpStatus httpStatus, String message) {
        return ResponseEntity.status(httpStatus).body(
                ResponseBody.builder().message(message).build()
        );
    }

    public static ResponseEntity<ResponseBody> withData(HttpStatus httpStatus, Object data) {
        return ResponseEntity.status(httpStatus).body(
                ResponseBody.builder().data(data).build()
        );
    }

    public static ResponseEntity<ResponseBody> withMessageAndData(HttpStatus httpStatus, String message, Object data) {
        return ResponseEntity.status(httpStatus).body(
                ResponseBody.builder().message(message).data(data).build()
        );
    }
}
