package lt.codeacademy.bookstore.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CategoryDTO {

    private Long id;

    @NotBlank(message = "Invalid name.")
    @Size(max = 100, message = "Name length above allowed limit.")
    private String name;

}


