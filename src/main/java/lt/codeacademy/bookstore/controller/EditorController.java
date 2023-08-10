package lt.codeacademy.bookstore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lt.codeacademy.bookstore.dto.EditorDTO;
import lt.codeacademy.bookstore.service.EditorService;

@RestController
@RequestMapping("/edit")
public class EditorController {

    @Autowired
    EditorService editorService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(editorService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable Long id){
        try {
            return ResponseEntity.ok(editorService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid EditorDTO editorDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(editorService.create(editorDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid EditorDTO editorDTO, @PathVariable Long id){
        try {
            return ResponseEntity.ok(editorService.edit(editorDTO, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            editorService.delete(id);
            return ResponseEntity.ok("Publisher with id "+id+" has been successfully removed!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
