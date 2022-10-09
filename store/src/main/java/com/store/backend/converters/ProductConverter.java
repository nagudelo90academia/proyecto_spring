package com.store.backend.converters;

import com.store.backend.data.ProductData;
import com.store.backend.entities.Product;

public class ProductConverter extends Converter<Product, ProductData> {

    // private UserConverter userConverter = new UserConverter();
    // private VacantConverter vacantConverter = new VacantConverter();
    private CategoryConverter categoryConverter = new CategoryConverter();
    private BrandConverter brandConverter = new BrandConverter();

    @Override
    public Product toEntity(ProductData object) {
        return object == null ? null
                : Product.builder()
                        .id(object.getId())
                        .category(categoryConverter.toEntity(object.getCategory()))
                        .brand(brandConverter.toEntity(object.getBrand()))
                        .name(object.getName())
                        .description(object.getDescription())
                        .image(object.getImage())
                        .price(object.getPrice())
                        .stock(object.getStock()) // faltan los sellers
                        .build();

    }

    @Override
    public ProductData toData(Product object) {
        return object == null ? null
                : ProductData.builder()
                        .id(object.getId())
                        .category(categoryConverter.toData(object.getCategory()))
                        .brand(brandConverter.toData(object.getBrand()))
                        .description(object.getDescription())
                        .image(object.getImage())
                        .price(object.getPrice())
                        .stock(object.getStock()) // faltan los sellers
                        .build();

    }

}
