package lt.codeacademy.bookstore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lt.codeacademy.bookstore.dto.LivroDTO;
import lt.codeacademy.bookstore.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroService livroService;


    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(livroService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoria(@PathVariable Long id){
        try {
            return ResponseEntity.ok(livroService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody @Valid LivroDTO livroDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(livroService.criar(livroDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody @Valid LivroDTO livroDTO, @PathVariable Long id){
        try {
            return ResponseEntity.ok(livroService.editar(livroDTO, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            livroService.deletar(id);
            return ResponseEntity.ok("Livro com id "+id+" foi removido com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/categoria")
    public ResponseEntity<Object> listarByCategoria(@RequestParam Long categoriaId){
        try{
            return ResponseEntity.ok(livroService.getByCategoria(categoriaId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/editora")
    public ResponseEntity<Object> listarByEditora(@RequestParam Long EditoraId){
        try{
            return ResponseEntity.ok(livroService.getByEditora(EditoraId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<Object> listarByNomeOrIsbn(@RequestParam(name = "nome", defaultValue = "") String nome, @RequestParam(name = "isbn", defaultValue = "") String isbn){
        try {
            return ResponseEntity.ok(livroService.getByNomeAndIsbn(nome, isbn));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
