package org.example.capstoneproject.customer.dto;

    import lombok.*;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public class ErrorResponse {
        private int errorCode;
        private String message;
    }

