package lt.codeacademy.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import lt.codeacademy.bookstore.mapper.EditoraMapper;
import lt.codeacademy.bookstore.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.codeacademy.bookstore.dto.EditoraDTO;
import lt.codeacademy.bookstore.model.Editora;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    EditoraRepository editoraRepository;

    @Autowired
    EditoraMapper editoraMapper;

    public List<EditoraDTO> listar() {
        return editoraMapper.updateListEditoraEntity(editoraRepository.findAll());
    }

    public EditoraDTO getById(Long id) {
        Optional<Editora> editoraOptional = editoraRepository.findById(id);
        if (editoraOptional.isPresent()) {
            return editoraMapper.updateEditora(editoraOptional.get());
        }
        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public EditoraDTO criar(EditoraDTO editora) {
        Editora editoraSave = editoraRepository.save(editoraMapper.updateEditora(editora));
        return editoraMapper.updateEditora(editoraSave);
    }

    public void deletar(Long id){
        Optional<Editora> editoraOptional = editoraRepository.findById(id);
        if (editoraOptional.isPresent()) {
             editoraRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public EditoraDTO editar(EditoraDTO editoraDTO, Long id){
        if (editoraRepository.existsById(id)){
            Editora editora = editoraMapper.updateEditora(editoraDTO);
            editora.setId(editoraDTO.getId());
            editoraRepository.save(editora);
            return editoraMapper.updateEditora(editora);
        }
        throw new EntityNotFoundException("Categoria não encontrada.");
    }
}