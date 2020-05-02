package ru.itis.springbootdemo.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ProfileForm {
    @NotNull(message = "{errors.incorrect.name}")
    private String name;

    @NotNull(message = "{errors.null.born}")
//    @Past(message = "{errors.incorrect.born}")
    private String born;

    private String about;

//    @Pattern(regexp = "^id*$")
//    @NotBlank
//    private String vkId;
}

