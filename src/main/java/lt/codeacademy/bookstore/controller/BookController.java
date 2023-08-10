package lt.codeacademy.bookstore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lt.codeacademy.bookstore.dto.BookDTO;
import lt.codeacademy.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(bookService.listar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable Long id){
        try {
            return ResponseEntity.ok(bookService.getById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid BookDTO bookDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(bookDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid BookDTO bookDTO, @PathVariable Long id){
        try {
            return ResponseEntity.ok(bookService.editor(bookDTO, id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try {
            bookService.delete(id);
            return ResponseEntity.ok("Book with ID "+id+" was successfully removed!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/category")
    public ResponseEntity<Object> listarByCategory(@RequestParam Long categoryId){
        try{
            return ResponseEntity.ok(bookService.getByCategory(categoryId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/editor")
    public ResponseEntity<Object> listarByEditor(@RequestParam Long EditorId){
        try{
            return ResponseEntity.ok(bookService.getByEditor(EditorId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<Object> listarByNameOrIsbn(@RequestParam(name = "name", defaultValue = "") String name, @RequestParam(name = "isbn", defaultValue = "") String isbn){
        try {
            return ResponseEntity.ok(bookService.getByNameAndIsbn(name, isbn));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
