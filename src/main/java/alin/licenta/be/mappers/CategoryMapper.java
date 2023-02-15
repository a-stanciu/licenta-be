package alin.licenta.be.mappers;

import alin.licenta.be.dto.CategoryDTO;
import alin.licenta.be.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class CategoryMapper {

    public abstract CategoryDTO entityToDto(Category category);

    public abstract Category dtoToEntity(CategoryDTO categoryDTO);
}
