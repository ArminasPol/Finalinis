package lt.codeacademy.bookstore.mapper;

import lt.codeacademy.bookstore.entities.Editor;
import org.springframework.stereotype.Component;
import lt.codeacademy.bookstore.dto.EditorDTO;

import java.util.List;

@Component
public class EditMapper {

    public Editor updateEditor(EditorDTO editor){
        Editor editorEntity = new Editor();
        editorEntity.setId(editor.getId());
        editorEntity.setName(editor.getName());
        editorEntity.setDescription(editor.getDescription());
        return editorEntity;
    }

    public EditorDTO updateEditor(Editor editor){
        EditorDTO editorDTO = new EditorDTO();
        editorDTO.setId(editor.getId());
        editorDTO.setName(editor.getName());
        editorDTO.setDescription(editor.getDescription());
        return editorDTO;
    }

    public List<Editor> updateListEditorDTO(List<EditorDTO> listEditorDTO){
        return listEditorDTO.stream()
                .map(categoryDTO -> this.updateEditor(categoryDTO))
                .toList();
    }

    public List<EditorDTO> updateListEditorEntity(List<Editor> listEditorEntity){
        return listEditorEntity.stream()
                .map(category -> this.updateEditor(category))
                .toList();
    }
}

