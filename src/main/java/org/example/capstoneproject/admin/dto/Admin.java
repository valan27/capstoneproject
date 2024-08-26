package org.example.capstoneproject.admin.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Admin {
    @Id
    @GeneratedValue
    private int adId;
    private String adName;
    private String adCity;
    private int adPinCode;
    private String adGender;
    private String adEmail;
    private String adPhone;
}
