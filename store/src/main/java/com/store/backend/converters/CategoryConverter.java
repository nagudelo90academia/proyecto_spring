package com.store.backend.converters;

import com.store.backend.data.CategoryData;
import com.store.backend.entities.Category;

public class CategoryConverter extends Converter<Category, CategoryData> {

    @Override
    public Category toEntity(CategoryData object) {
        return object == null ? null
                : Category.builder()
                        .id(object.getId())
                        .name(object.getName())
                        .build();
    }

    @Override
    public CategoryData toData(Category object) {
        return object == null ? null
                : CategoryData.builder()
                        .id(object.getId())
                        .name(object.getName())
                        .build();
    }

}