package lt.codeacademy.bookstore.repository;

import lt.codeacademy.bookstore.entities.Book;
import lt.codeacademy.bookstore.entities.Category;
import lt.codeacademy.bookstore.entities.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByCategory(Category category);

    List<Book> findBookByEditor(Editor editor);

    @Query("SELECT l FROM Book l WHERE l.name LIKE CONCAT('%',UPPER(:termoName),'%')AND l.isbn = :termoIsbn")
    List<Book> findByNameAndIsbn(@Param("termoName") String termoName, @Param("termoIsbn") String termoIsbn);
}
