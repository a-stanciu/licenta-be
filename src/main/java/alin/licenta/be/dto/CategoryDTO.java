package alin.licenta.be.dto;

import alin.licenta.be.entities.Subcategory;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CategoryDTO {

    private int id;

    private String name;

    private List<Subcategory> subcategoryList;
}
