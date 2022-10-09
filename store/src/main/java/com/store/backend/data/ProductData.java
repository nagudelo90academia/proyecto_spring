package com.store.backend.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {

    private int id;
    private CategoryData category;
    private BrandData brand;
    private String name;
    private String description;
    private String image;
    private Double price;
    private Double stock;
    private List<SellerData> sellers;
}
