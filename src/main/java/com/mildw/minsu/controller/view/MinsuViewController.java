package com.mildw.minsu.controller.view;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MinsuViewController {

    @ApiOperation("인덱스 페이지")
    @GetMapping("/")
    public String index() {
        return "page/index";
    }

    @ApiOperation("로그인 페이지")
    @GetMapping("/login")
    public String login() {
        return "page/login/index";
    }

    @ApiOperation("관리자 페이지")
    @GetMapping("/admin/index")
    public String admin() {
        return "page/admin/index";
    }

}
