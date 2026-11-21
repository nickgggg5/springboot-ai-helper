package com.powernode.aispringboot.controller;

import com.powernode.aispringboot.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class Test {
    @GetMapping("/test")
    public Result<Object> test() {
        Result<Object> result = new Result<>();
        result.setCode("200");
        result.setMsg("hello world");
        return result.ok();
    }
}
