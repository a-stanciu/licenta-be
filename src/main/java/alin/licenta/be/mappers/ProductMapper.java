package alin.licenta.be.mappers;

import alin.licenta.be.dto.ProductRequestDTO;
import alin.licenta.be.dto.ProductResponseDTO;
import alin.licenta.be.entities.Product;
import alin.licenta.be.entities.Subcategory;
import alin.licenta.be.services.SubcategoryService;
import alin.licenta.be.util.ImageHostingUtil;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class ProductMapper {

    @Autowired
    protected SubcategoryService subcategoryService;

    @Autowired
    private ImageHostingUtil imageHostingUtil;

    public abstract ProductResponseDTO entityToDto(Product product);

    public abstract Product dtoToEntity(ProductRequestDTO productRequestDTO);

    protected int fromSubcategoryToInteger(Subcategory value) {
        return value.getId();
    }

    protected Subcategory fromIntegerToSubcategory(int value) {
        return subcategoryService.findEntityById(value);
    }

    @AfterMapping
    public void fromBase64PictureToPictureUri(@MappingTarget Product product, ProductRequestDTO productRequestDTO) {
        String pictureUri = imageHostingUtil.hostImage(String.valueOf(productRequestDTO.hashCode()), productRequestDTO.getBase64Picture());

        product.setPictureUrl(pictureUri);
    }
}
