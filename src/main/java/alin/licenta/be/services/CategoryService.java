package alin.licenta.be.services;

import alin.licenta.be.dto.CategoryDTO;
import alin.licenta.be.entities.Category;
import alin.licenta.be.mappers.CategoryMapper;
import alin.licenta.be.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Category create(CategoryDTO categoryDTO) {
        return categoryRepository.save(categoryMapper.dtoToEntity(categoryDTO));
    }

    public Category update(int id, CategoryDTO categoryDTO) {
        categoryDTO.setId(id);
        return categoryRepository.save(categoryMapper.dtoToEntity(categoryDTO));
    }

    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    public Category findEntityById(int id) {
        return categoryRepository
                .findById(id)
                .orElse(null);
    }

    public CategoryDTO findDTOById(int id) {
        return categoryMapper.entityToDto(findEntityById(id));
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::entityToDto)
                .toList();
    }
}
