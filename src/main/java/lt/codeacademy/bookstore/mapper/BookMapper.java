package lt.codeacademy.bookstore.mapper;

import lt.codeacademy.bookstore.entities.Book;
import org.springframework.stereotype.Component;
import lt.codeacademy.bookstore.dto.BookDTO;
import lt.codeacademy.bookstore.entities.Book;

import java.util.List;

@Component
public class BookMapper {

    EditMapper editorMapper = new EditMapper();
    CategoryMapper categoryMapper = new CategoryMapper();

    public Book updateBook(BookDTO book){
        Book bookEntity = new Book();
        bookEntity.setId(book.getId());
        bookEntity.setName(book.getName());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setEditor(editorMapper.updateEditor(book.getEditor()));
        bookEntity.setCategory(categoryMapper.updateCategory(book.getCategory()));
        return bookEntity;
    }

    public BookDTO updateBook(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setEditor(editorMapper.updateEditor(book.getEditor()));
        bookDTO.setCategory(categoryMapper.updateCategory(book.getCategory()));
        return bookDTO;
    }

    public List<Book> updateListBookDTO(List<BookDTO> books){
        return books.stream()
                .map(book -> this.updateBook(book))
                .toList();
    }

    public List<BookDTO> updateListBookEntity(List<Book> books){
        return books.stream()
                .map(book -> this.updateBook(book))
                .toList();
    }

}