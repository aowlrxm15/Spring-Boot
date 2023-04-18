package kr.co.voard.controller;


import kr.co.voard.entity.UserEntity;
import kr.co.voard.jwt.JwtUtil;
import kr.co.voard.security.MyUserDetails;
import kr.co.voard.security.SecurityUserService;
import kr.co.voard.vo.User1VO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@AllArgsConstructor
@RestController
public class UserController{

    private AuthenticationManager authenticationManager;
    private SecurityUserService securityUserService;
    private JwtUtil jwtUtil;

    @GetMapping("/user")
    public UserEntity user(@AuthenticationPrincipal Principal principal) {
        MyUserDetails myUserDetails = (MyUserDetails) principal;

        return myUserDetails.getUser();
    }
    @PostMapping("/user/login")
    public Map<String, Object> login (@RequestBody User1VO vo){
        log.info("vo :" + vo);

        String uid = vo.getUid();
        String pass = vo.getPass();

        log.info("login...1");

        // Security 인증처리
        MyUserDetails myUserDetails = securityUserService.loadUserByUsername(uid);
        log.info("login...2");

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myUserDetails, pass));

        log.info("login...3");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // JWT 생성
        String token = jwtUtil.generateToken(uid);
        log.info("login...4");

        // JWT 출력
        UserEntity user = myUserDetails.getUser();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("accessToken", token);
        resultMap.put("user", user);
        return resultMap;

    }
    public void logout (){

    }
}