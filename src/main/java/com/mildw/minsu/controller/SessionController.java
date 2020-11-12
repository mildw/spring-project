package com.mildw.minsu.controller;

import com.mildw.minsu.controller.jwtAuth.rqrs.JwtAuthRq;
import com.mildw.minsu.controller.jwtAuth.rqrs.JwtAuthRs;
import com.mildw.minsu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final UserService userService;

    @GetMapping("/login")
    public ResponseEntity<JwtAuthRs> login(@RequestBody JwtAuthRq jwtAuthRq) {
        String token = userService.createToken(jwtAuthRq);
        return ResponseEntity.ok().body(new JwtAuthRs(token));
    }
}
