package alin.licenta.be.dto;

import alin.licenta.be.entities.Product;
import lombok.Data;

import java.util.List;

@Data
public class SubcategoryDTO {

    private int id;

    private String name;

    private List<Product> productList;

    private int category;
}
