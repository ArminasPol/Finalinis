package lt.codeacademy.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lt.codeacademy.bookstore.entities.Editor;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
}
