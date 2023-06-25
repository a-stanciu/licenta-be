package alin.licenta.be.dto;

import alin.licenta.be.entities.Variant;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductResponseDTO {

    private int id;

    private String name;

    private int price;

    private String description;

    private Date addedDate;

    private String pictureUrl;

    private String transparentPictureUrl;

    private List<Variant> variantList;

    private SubcategoryResponseDTO subcategory;
}
