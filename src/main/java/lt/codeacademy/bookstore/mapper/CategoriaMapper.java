package lt.codeacademy.bookstore.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.bookstore.dto.CategoriaDTO;
import lt.codeacademy.bookstore.model.Categoria;

import java.util.List;

@Component
public class CategoriaMapper {

    public Categoria updateCategoria(CategoriaDTO categoria){
        Categoria categoriaEntity = new Categoria();
        categoriaEntity.setId(categoria.getId());
        categoriaEntity.setNome(categoria.getNome());
        return categoriaEntity;
    }

    public CategoriaDTO updateCategoria(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNome(categoria.getNome());
        return categoriaDTO;
    }

    public List<Categoria> updateListCategoriaDTO(List<CategoriaDTO> listCategoriaDTO){
        return listCategoriaDTO.stream()
                .map(categoriaDTO -> this.updateCategoria(categoriaDTO))
                .toList();
    }

    public List<CategoriaDTO> updateListCategoriaEntity(List<Categoria> listCategoriaEntity){
        return listCategoriaEntity.stream()
                .map(categoria -> this.updateCategoria(categoria))
                .toList();
    }
}
