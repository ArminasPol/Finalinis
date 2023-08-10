package lt.codeacademy.bookstore.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.bookstore.dto.EditoraDTO;
import lt.codeacademy.bookstore.model.Editora;

import java.util.List;

@Component
public class EditoraMapper {

    public Editora updateEditora(EditoraDTO editora){
        Editora editoraEntity = new Editora();
        editoraEntity.setId(editora.getId());
        editoraEntity.setNome(editora.getNome());
        editoraEntity.setDescricao(editora.getDescricao());
        return editoraEntity;
    }

    public EditoraDTO updateEditora(Editora editora){
        EditoraDTO editoraDTO= new EditoraDTO();
        editoraDTO.setId(editora.getId());
        editoraDTO.setNome(editora.getNome());
        editoraDTO.setDescricao(editora.getDescricao());
        return editoraDTO;
    }

    public List<Editora> updateListEditoraDTO(List<EditoraDTO> listEditoraDTO){
        return listEditoraDTO.stream()
                .map(categoriaDTO -> this.updateEditora(categoriaDTO))
                .toList();
    }

    public List<EditoraDTO> updateListEditoraEntity(List<Editora> listEditoraEntity){
        return listEditoraEntity.stream()
                .map(categoria -> this.updateEditora(categoria))
                .toList();
    }
}

