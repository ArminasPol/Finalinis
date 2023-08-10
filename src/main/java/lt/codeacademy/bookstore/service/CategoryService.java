package lt.codeacademy.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import lt.codeacademy.bookstore.entities.Category;
import lt.codeacademy.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.codeacademy.bookstore.dto.CategoryDTO;
import lt.codeacademy.bookstore.mapper.CategoryMapper;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;
    String message = "Category not found.";
    public List<CategoryDTO> listar() {
        return categoryMapper.updateListCategoryEntity(categoryRepository.findAll());
    }

    public CategoryDTO getById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            return categoryMapper.updateCategory(categoryOptional.get());
        }

        throw new EntityNotFoundException(message);
    }

    public void delete(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            categoryRepository.delete(categoryOptional.get());
        }

        throw new EntityNotFoundException(message);
    }

    public CategoryDTO editor(CategoryDTO category, Long id) {
        if (categoryRepository.existsById(id)) {
            Category categoryEntity = categoryMapper.updateCategory(category);
            categoryEntity.setId(category.getId());
            Category categorySave = categoryRepository.save(categoryEntity);
            return categoryMapper.updateCategory(categorySave);
        }
        throw new EntityNotFoundException(message);
    }

    public CategoryDTO create(CategoryDTO categoryDTO) {
        Category categorySave = categoryRepository.save(categoryMapper.updateCategory(categoryDTO));
        return categoryMapper.updateCategory(categorySave);
    }
}
