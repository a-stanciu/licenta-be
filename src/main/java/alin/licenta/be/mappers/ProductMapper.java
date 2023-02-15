package alin.licenta.be.mappers;

import alin.licenta.be.dto.ProductDTO;
import alin.licenta.be.entities.Product;
import alin.licenta.be.entities.Subcategory;
import alin.licenta.be.services.SubcategoryService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class ProductMapper {

    @Autowired
    protected SubcategoryService subcategoryService;

    public abstract ProductDTO entityToDto(Product product);

    public abstract Product dtoToEntity(ProductDTO productDTO);

    protected int fromSubcategoryToInteger(Subcategory value) {
        return value.getId();
    }

    protected Subcategory fromIntegerToSubcategory(int value) {
        return subcategoryService.findEntityById(value);
    }
}
