package alin.licenta.be.dto;

import alin.licenta.be.entities.Category;
import alin.licenta.be.entities.Product;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SubcategoryDTO {

    private int id;

    private String name;

    private List<Product> productList;

    private Category category;
}
