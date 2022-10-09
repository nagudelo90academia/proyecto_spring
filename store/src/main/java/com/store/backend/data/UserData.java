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
public class UserData {

    private int id;
    private String name;
    private String email;
    private String password;
    private List<RoleData> roles;
    private List<SellerData> sellers;
}