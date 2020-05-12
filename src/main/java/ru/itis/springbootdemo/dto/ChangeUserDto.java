package ru.itis.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.models.FileInfo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeUserDto {
    @NotEmpty(message = "{errors.incorrect.name}")
    @Size(min=1, message = "{errors.incorrect.name}")
    private String name;
    @NotEmpty(message = "{errors.incorrect.about}")
    @Size(min=1, message = "{errors.incorrect.about}")
    private String about;
    private MultipartFile img;
//    @NotNull(message = "{errors.null.born}")
//    private String born;

}
