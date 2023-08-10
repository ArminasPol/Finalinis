package lt.codeacademy.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LivroDTO {

    private Long id;

    @NotBlank(message = "Nome inválido.")
    private String nome;

    @NotBlank(message = "Número ISB inválido.")
    @Size(max = 13, message = "Número ISBN maior que o permitido.")
    private String isbn;

    private EditoraDTO editora;

    private CategoriaDTO categoria;
}
