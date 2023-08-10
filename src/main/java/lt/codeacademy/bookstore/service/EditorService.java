package lt.codeacademy.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import lt.codeacademy.bookstore.entities.Editor;
import lt.codeacademy.bookstore.mapper.EditMapper;
import lt.codeacademy.bookstore.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.codeacademy.bookstore.dto.EditorDTO;

import java.util.List;
import java.util.Optional;

@Service
public class EditorService {

    @Autowired
    EditorRepository editorRepository;

    @Autowired
    EditMapper editMapper;

    public List<EditorDTO> listar() {
        return editMapper.updateListEditorEntity(editorRepository.findAll());
    }

    public EditorDTO getById(Long id) {
        Optional<Editor> editorOptional = editorRepository.findById(id);
        if (editorOptional.isPresent()) {
            return editMapper.updateEditor(editorOptional.get());
        }
        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public EditorDTO create(EditorDTO editor) {
        Editor editorSave = editorRepository.save(editMapper.updateEditor(editor));
        return editMapper.updateEditor(editorSave);
    }

    public void delete(Long id){
        Optional<Editor> editorOptional = editorRepository.findById(id);
        if (editorOptional.isPresent()) {
             editorRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public EditorDTO edit(EditorDTO editorDTO, Long id){
        if (editorRepository.existsById(id)){
            Editor editor = editMapper.updateEditor(editorDTO);
            editor.setId(editorDTO.getId());
            editorRepository.save(editor);
            return editMapper.updateEditor(editor);
        }
        throw new EntityNotFoundException("Categoria não encontrada.");
    }
}