package org.example.capstoneproject.cart.dto;

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

