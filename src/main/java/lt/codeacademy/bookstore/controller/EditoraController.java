package lt.codeacademy.bookstore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lt.codeacademy.bookstore.dto.EditoraDTO;
import lt.codeacademy.bookstore.service.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    EditoraService editoraService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(editoraService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoria(@PathVariable Long id){
        try {
            return ResponseEntity.ok(editoraService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody @Valid EditoraDTO editoraDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.criar(editoraDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(@RequestBody @Valid EditoraDTO editoraDTO, @PathVariable Long id){
        try {
            return ResponseEntity.ok(editoraService.editar(editoraDTO, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            editoraService.deletar(id);
            return ResponseEntity.ok("Editora com id "+id+" foi removida com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
