package alin.licenta.be.dto;

import alin.licenta.be.entities.Subcategory;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {

    private int id;

    private String name;

    private List<Subcategory> subcategoryList;
}
