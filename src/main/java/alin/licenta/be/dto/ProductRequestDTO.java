package alin.licenta.be.dto;

import alin.licenta.be.entities.Variant;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductRequestDTO {

    private int id;

    private String name;

    private int price;

    private String description;

    private Date addedDate;

    private String base64Picture;

    private String base64TransparentPicture;

    private List<Variant> variantList;

    private int subcategory;
}
