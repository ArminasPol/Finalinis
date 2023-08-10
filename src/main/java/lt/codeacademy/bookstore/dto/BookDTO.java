package lt.codeacademy.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookDTO {

    private Long id;

    @NotBlank(message = "Invalid name.")
    private String name;

    @NotBlank(message = "Invalid ISB number.")
    @Size(max = 13, message = "ISBN number greater than allowed")
    private String isbn;

    private EditorDTO editor;

    private CategoryDTO category;
}
