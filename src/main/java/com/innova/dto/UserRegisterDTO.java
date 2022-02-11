package com.innova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class UserRegisterDTO {
    @NotEmpty(message = "Kullanici adini bos birakamazsiniz!")
    private String userName;

    @NotEmpty(message = "Email alanini bos birakamazsiniz!")
    @Email(message = "Email formatina uygun sekilde doldurunuz.")
    private String userMail;

    @Size(min=6,max=15)
    @NotEmpty(message = "Sifre alanini bos birakamazsiniz!")
    private String userPassword;

}
