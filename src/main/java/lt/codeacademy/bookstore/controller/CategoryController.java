package lt.codeacademy.bookstore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lt.codeacademy.bookstore.dto.CategoryDTO;
import lt.codeacademy.bookstore.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(categoryService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable Long id){
        try {
            return ResponseEntity.ok(categoryService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid CategoryDTO categoryDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(categoryDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid CategoryDTO categoryDTO, @PathVariable Long id){
        try {
            return ResponseEntity.ok(categoryService.editor(categoryDTO, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            categoryService.delete(id);
            return ResponseEntity.ok("Category with id "+id+" was removed successfully!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}