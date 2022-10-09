package com.store.backend.converters;

import com.store.backend.data.UserData;
import com.store.backend.entities.User;

public class UserConverter extends Converter<User, UserData> {

    private RoleConverter roleConverter = new RoleConverter();
    private SellerConverter sellerConverter = new SellerConverter();

    @Override
    public User toEntity(UserData object) {
        return object == null ? null
                : User.builder()
                        .id(object.getId())
                        .name(object.getName())
                        .email(object.getEmail())
                        .password(object.getPassword())
                        .roles(roleConverter.toEntity(object.getRoles()))
                        .sellers(sellerConverter.toEntity(object.getSellers()))
                        .build();
    }

    @Override
    public UserData toData(User object) {
        return object == null ? null
                : UserData.builder()
                        .id(object.getId())
                        .name(object.getName())
                        .email(object.getEmail())
                        .password(null)
                        .roles(roleConverter.toData(object.getRoles()))
                        .sellers(sellerConverter.toData(object.getSellers()))
                        .build();
    }

}