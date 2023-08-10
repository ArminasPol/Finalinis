package lt.codeacademy.bookstore.mapper;

import org.springframework.stereotype.Component;
import lt.codeacademy.bookstore.dto.LivroDTO;
import lt.codeacademy.bookstore.model.Livro;

import java.util.List;

@Component
public class LivroMapper {

    EditoraMapper editoraMapper = new EditoraMapper();
    CategoriaMapper categoriaMapper = new CategoriaMapper();

    public Livro updateLivro(LivroDTO livro){
        Livro livroEntity = new Livro();
        livroEntity.setId(livro.getId());
        livroEntity.setNome(livro.getNome());
        livroEntity.setIsbn(livro.getIsbn());
        livroEntity.setEditora(editoraMapper.updateEditora(livro.getEditora()));
        livroEntity.setCategoria(categoriaMapper.updateCategoria(livro.getCategoria()));
        return livroEntity;
    }

    public LivroDTO updateLivro(Livro livro){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setNome(livro.getNome());
        livroDTO.setIsbn(livro.getIsbn());
        livroDTO.setEditora(editoraMapper.updateEditora(livro.getEditora()));
        livroDTO.setCategoria(categoriaMapper.updateCategoria(livro.getCategoria()));
        return livroDTO;
    }

    public List<Livro> updateListLivroDTO(List<LivroDTO> livros){
        return livros.stream()
                .map(livro -> this.updateLivro(livro))
                .toList();
    }

    public List<LivroDTO> updateListLivroEntity(List<Livro> livros){
        return livros.stream()
                .map(livro -> this.updateLivro(livro))
                .toList();
    }

}
