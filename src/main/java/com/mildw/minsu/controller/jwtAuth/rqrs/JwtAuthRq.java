package com.mildw.minsu.controller.jwtAuth.rqrs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtAuthRq {

    private String UserId;
    private String UserPasswd;

}
