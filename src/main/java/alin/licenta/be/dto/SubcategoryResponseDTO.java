package alin.licenta.be.dto;

import alin.licenta.be.entities.Category;
import lombok.Data;

@Data
public class SubcategoryResponseDTO {

    private int id;

    private String name;

    private Category category;
}
