package alin.licenta.be.mappers;

import alin.licenta.be.dto.VariantDTO;
import alin.licenta.be.entities.AssignedValue;
import alin.licenta.be.entities.Product;
import alin.licenta.be.entities.Variant;
import alin.licenta.be.services.AssignedValueService;
import alin.licenta.be.services.ProductService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class VariantMapper {

    @Autowired
    protected ProductService productService;

    @Autowired
    protected AssignedValueService assignedValueService;

    public abstract VariantDTO entityToDto(Variant variant);

    public abstract Variant dtoToEntity(VariantDTO variantDTO);

    protected int fromProductToInteger(Product value) {
        return value.getId();
    }

    protected Product fromIntegerToProduct(int value) {
        return productService.findEntityById(value);
    }

    protected List<Integer> fromAssignedValueListToIntegerList(List<AssignedValue> value) {
        return value
                .stream()
                .map(AssignedValue::getId)
                .toList();
    }

    protected List<AssignedValue> fromIntegerListToAssignedValueList(List<Integer> value) {
        return value
                .stream()
                .map(assignedValueService::findEntityById)
                .toList();
    }
}
