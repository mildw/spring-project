package com.mildw.minsu.controller.jwtAuth.rqrs;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class JwtAuthRq {

    @NonNull
    private String UserEmail;
    @NonNull
    private String UserPassWord;

}
