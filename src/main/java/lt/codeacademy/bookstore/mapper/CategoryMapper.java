package lt.codeacademy.bookstore.mapper;

import lt.codeacademy.bookstore.entities.Category;
import org.springframework.stereotype.Component;
import lt.codeacademy.bookstore.dto.CategoryDTO;

import java.util.List;

@Component
public class CategoryMapper {

    public Category updateCategory(CategoryDTO category){
        Category categoryEntity = new Category();
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());
        return categoryEntity;
    }

    public CategoryDTO updateCategory(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public List<Category> updateListCategoryDTO(List<CategoryDTO> listCategoryDTO){
        return listCategoryDTO.stream()
                .map(categoryDTO -> this.updateCategory(categoryDTO))
                .toList();
    }

    public List<CategoryDTO> updateListCategoryEntity(List<Category> listCategoryEntity){
        return listCategoryEntity.stream()
                .map(category -> this.updateCategory(category))
                .toList();
    }
}
