package com.store.backend.converters;

import com.store.backend.data.SellerData;
import com.store.backend.entities.Seller;

public class SellerConverter extends Converter<Seller, SellerData> {

    @Override
    public Seller toEntity(SellerData object) {
        return object == null ? null
                : Seller.builder()
                        .id(object.getId())
                        .name(object.getName())
                        .status(object.getStatus())
                        .build();
    }

    @Override
    public SellerData toData(Seller object) {
        return object == null ? null
                : SellerData.builder()
                        .id(object.getId())
                        .name(object.getName())
                        .status(object.getStatus())
                        .build();
    }

}