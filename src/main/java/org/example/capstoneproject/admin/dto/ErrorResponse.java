package org.example.capstoneproject.admin.dto;

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

