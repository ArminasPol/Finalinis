package lt.codeacademy.bookstore.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CategoriaDTO {

    private Long id;

    @NotBlank(message = "Nome inválido.")
    @Size(max = 100, message = "Tamanho de nome acima do limite permitido.")
    private String nome;

}


