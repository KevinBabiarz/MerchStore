package com.example.merchstore.models.DTOs;

import com.example.merchstore.models.entities.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {

        private Long id;
        private String name;
        private Long quantity;
        private String img;
        private Long price;

        public static ProductDTO toDTO(Product product){

            if( product == null )
                return null;

            return ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .quantity(product.getQuantity())
                    .img(product.getImg())
                    .price(product.getPrice())
                    .build();
        }


}
