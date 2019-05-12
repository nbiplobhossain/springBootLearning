package com.example.demo.dtos;

import lombok.Data;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AddUserDTO {

    @NotBlank
    private String name;

    @Email
    private String email;
}
