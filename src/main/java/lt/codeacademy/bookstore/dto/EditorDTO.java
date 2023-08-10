package lt.codeacademy.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditorDTO {

    private Long id;

    @NotBlank(message = "Invalid name.")
    @Size(max = 100, message = "Name length above allowed limit.")
    private String name;

    private String description;

}
