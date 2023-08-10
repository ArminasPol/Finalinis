package lt.codeacademy.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditoraDTO {

    private Long id;

    @NotBlank(message = "Nome inválido.")
    @Size(max = 100, message = "Tamanho de nome acima do limite permitido.")
    private String nome;

    private String descricao;

}
