package lt.codeacademy.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lt.codeacademy.bookstore.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
