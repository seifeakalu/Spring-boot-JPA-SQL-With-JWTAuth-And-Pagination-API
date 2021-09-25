package com.seifeakalu.jwt.api.entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_TBL")
public class AuthRequest {

    private String userName;
    private String password;
   
}
