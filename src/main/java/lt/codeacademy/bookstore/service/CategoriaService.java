package lt.codeacademy.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import lt.codeacademy.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.codeacademy.bookstore.dto.CategoriaDTO;
import lt.codeacademy.bookstore.mapper.CategoriaMapper;
import lt.codeacademy.bookstore.model.Categoria;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> listar(){
        return categoriaMapper.updateListCategoriaEntity(categoriaRepository.findAll());
    }

    public CategoriaDTO getById(Long id){
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isPresent()){
            return categoriaMapper.updateCategoria(categoriaOptional.get());
        }

        throw new EntityNotFoundException("Categoria não encontrada.");
    }
    public void deletar(Long id){
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isPresent()){
             categoriaRepository.delete(categoriaOptional.get());
        }

        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public CategoriaDTO editar(CategoriaDTO categoria, Long id){
        if (categoriaRepository.existsById(id)){
            Categoria categoriaEntity = categoriaMapper.updateCategoria(categoria);
            categoriaEntity.setId(categoria.getId());
            Categoria categoriaSave = categoriaRepository.save(categoriaEntity);
            return categoriaMapper.updateCategoria(categoriaSave);
        }
        throw new EntityNotFoundException("Categoria não encontrada.");
    }

    public CategoriaDTO criar(CategoriaDTO categoriaDTO){
        Categoria categoriaSave = categoriaRepository.save(categoriaMapper.updateCategoria(categoriaDTO));
        return categoriaMapper.updateCategoria(categoriaSave);
    }
}
