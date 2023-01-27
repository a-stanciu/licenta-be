package alin.licenta.be.dto;

import alin.licenta.be.entities.Subcategory;
import alin.licenta.be.entities.Variant;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class ProductDTO {

    private int id;

    private String name;

    private Date addedDate;

    private String pictureUrl;

    private List<Variant> variantList;

    private Subcategory subcategory;
}
