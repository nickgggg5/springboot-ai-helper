package com.powernode.aispringboot.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.powernode.aispringboot.DTO.command.UserRegisterCommandDTO;
import com.powernode.aispringboot.DTO.response.UserLoginResponseDTO;
import com.powernode.aispringboot.Service.UserService;
import com.powernode.aispringboot.Util.JwtTokenUtil;
import com.powernode.aispringboot.common.Result;
import com.powernode.aispringboot.DTO.command.UserLoginCommandDTO;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class User {
    @Resource
    private UserService userService;

    // 登录
    @PostMapping("/login")
    public Result<UserLoginResponseDTO> login(@Valid @RequestBody UserLoginCommandDTO commandDTO) {

        // 调用服务层登录方法
     UserLoginResponseDTO result = userService.login(commandDTO);
        return Result.ok(result);
    }

    // 用户注册接口
    @PostMapping("/add")
    public Result<UserLoginResponseDTO.UserDetailResponseDTO> register(@Valid @RequestBody UserRegisterCommandDTO commandDTO) {
        UserLoginResponseDTO.UserDetailResponseDTO result = userService.register(commandDTO);
        return Result.ok(result);
    }

    // 获取当前用户
    @GetMapping("/current")
    public Result<UserLoginResponseDTO.UserDetailResponseDTO> getCurrentUser() {
        // 如何从token中解析出用户的id
        String token = JwtTokenUtil.getCurrentToken();
        DecodedJWT jwt = JwtTokenUtil.verifyToken(token);
        Long userId = jwt.getClaim("userId").asLong();
// 调用service层获取用户详情
        UserLoginResponseDTO.UserDetailResponseDTO result = userService.getUserById(userId);
        return Result.ok(result);
    }

}