package alin.licenta.be.mappers;

import alin.licenta.be.dto.SubcategoryRequestDTO;
import alin.licenta.be.dto.SubcategoryResponseDTO;
import alin.licenta.be.entities.Category;
import alin.licenta.be.entities.Subcategory;
import alin.licenta.be.services.CategoryService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class SubcategoryMapper {

    @Autowired
    protected CategoryService categoryService;

    public abstract SubcategoryResponseDTO entityToDto(Subcategory subcategory);

    public abstract Subcategory dtoToEntity(SubcategoryRequestDTO subcategoryRequestDTO);

    protected int fromCategoryToInteger(Category value) {
        return value.getId();
    }

    protected Category fromIntegerToCategory(int value) {
        return categoryService.findEntityById(value);
    }
}
