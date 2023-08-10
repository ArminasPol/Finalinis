package lt.codeacademy.bookstore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lt.codeacademy.bookstore.dto.CategoriaDTO;
import lt.codeacademy.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(categoriaService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/labas")
    public String labas(){
        return "Hello";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoria(@PathVariable Long id){
        try {
            return ResponseEntity.ok(categoriaService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody @Valid CategoriaDTO categoriaDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.criar(categoriaDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody @Valid CategoriaDTO categoriaDTO, @PathVariable Long id){
        try {
            return ResponseEntity.ok(categoriaService.editar(categoriaDTO, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            categoriaService.deletar(id);
            return ResponseEntity.ok("Categoria com id "+id+" foi removida com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}