package lt.codeacademy.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import lt.codeacademy.bookstore.entities.Book;
import lt.codeacademy.bookstore.entities.Category;
import lt.codeacademy.bookstore.mapper.CategoryMapper;
import lt.codeacademy.bookstore.mapper.EditMapper;
import lt.codeacademy.bookstore.mapper.BookMapper;
import lt.codeacademy.bookstore.repository.CategoryRepository;
import lt.codeacademy.bookstore.repository.EditorRepository;
import lt.codeacademy.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.codeacademy.bookstore.dto.BookDTO;
import lt.codeacademy.bookstore.entities.Editor;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    EditorRepository editorRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    EditMapper editMapper;
    String message = "Book not found.";

    public List<BookDTO> listar() {
        return bookMapper.updateListBookEntity(bookRepository.findAll());
    }

    public BookDTO getById(Long id) {
        Optional<Book> editorOptional = bookRepository.findById(id);
        if (editorOptional.isPresent()) {
            return bookMapper.updateBook(editorOptional.get());
        }
        throw new EntityNotFoundException(message);
    }

    public BookDTO create(BookDTO book) {
        Book bookSave = bookRepository.save(bookMapper.updateBook(book));
        return bookMapper.updateBook(bookSave);
    }

    public void delete(Long id) {
        Optional<Book> editorOptional = bookRepository.findById(id);
        if (editorOptional.isPresent()) {
            bookRepository.deleteById(id);
        }
        throw new EntityNotFoundException(message);
    }

    public BookDTO editor(BookDTO bookDTO, Long id) {
        if (bookRepository.existsById(id)) {
            Book book = bookMapper.updateBook(bookDTO);
            book.setId(bookDTO.getId());
            bookRepository.save(book);
            return bookMapper.updateBook(book);
        }
        throw new EntityNotFoundException(message);
    }

    public List<BookDTO> getByCategory(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isPresent()) {
            List<Book> books = bookRepository.findBookByCategory(categoryOptional.get());
            return bookMapper.updateListBookEntity(books);
        }
        throw new EntityNotFoundException(message);
    }

    public List<BookDTO> getByEditor(Long editorId) {
        Optional<Editor> editorOptional = editorRepository.findById(editorId);
        if (editorOptional.isPresent()) {
            List<Book> books = bookRepository.findBookByEditor(editorOptional.get());
            return bookMapper.updateListBookEntity(books);
        }
        throw new EntityNotFoundException(message);
    }

    public List<BookDTO> getByNameAndIsbn(String nameBook, String isbn) {
        List<Book> books = bookRepository.findByNameAndIsbn(nameBook, isbn);
        return bookMapper.updateListBookEntity(books);
    }
}

