package com.bringup.bringup.Controller;

import com.bringup.bringup.domain.payload.request.user.MyPage;
import com.bringup.bringup.domain.payload.request.user.SignUpRequest;
import com.bringup.bringup.domain.payload.request.user.UserPw;
import com.bringup.bringup.service.user.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl service;

    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpRequest signUpRequest) {

        service.SignUp(signUpRequest);
    }

    @PutMapping
    public void changPw(@RequestHeader("Authorization") String token, @RequestBody UserPw userPw) {

         service.changPw(token, userPw);
    }

    @GetMapping("/mypage")
    public List<MyPage> page(@RequestHeader("Authorization") String token) {

        return service.pageList(token);
    }
}
