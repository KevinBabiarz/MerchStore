package com.example.merchstore.models.forms;

import com.example.merchstore.models.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductForm {

    @NotBlank
    private String name;

    @NotNull
    private Long quantity;

    private String img;

    private Long price;

    public Product toEntity(){
         Product product = new Product();
         product.setName(this.name);
         product.setQuantity(this.quantity);
         product.setImg(this.img);
         product.setPrice(this.price);
         return product;
    }
}
