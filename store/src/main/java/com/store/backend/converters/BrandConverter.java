package com.store.backend.converters;

import com.store.backend.data.BrandData;
import com.store.backend.entities.Brand;

public class BrandConverter extends Converter<Brand, BrandData> {

    @Override
    public Brand toEntity(BrandData object) {
        return object == null ? null
                : Brand.builder()
                        .id(object.getId())
                        .name(object.getName())
                        .build();
    }

    @Override
    public BrandData toData(Brand object) {
        return object == null ? null
                : BrandData.builder()
                        .id(object.getId())
                        .name(object.getName())
                        .build();
    }

}