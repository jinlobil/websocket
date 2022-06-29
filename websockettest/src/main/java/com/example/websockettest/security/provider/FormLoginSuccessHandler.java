package com.example.websockettest.security.provider;

import com.example.websockettest.dto.responsedto.LoginResponseDto;
import com.example.websockettest.dto.responsedto.UserResponseDto;
import com.example.websockettest.model.User;
import com.example.websockettest.security.jwt.JwtTokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FormLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_TYPE = "BEARER";

    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) throws IOException {
        final UserDetailsImpl userDetails = ((UserDetailsImpl) authentication.getPrincipal());
        // Token 생성
        final String token = JwtTokenUtils.generateJwtToken(userDetails);
        System.out.println("FormLoginSuccessHandler token = " + token);
        response.addHeader(AUTH_HEADER, TOKEN_TYPE + " " + token);
        response.addHeader("nickname", userDetails.getUser().getNickname());
        response.addHeader("profileUrl", userDetails.getUser().getProfileUrl());




        //UserId 내려주기
        response.setContentType("application/json; charset=utf-8");
        User user = userDetails.getUser();
        LoginResponseDto loginResponseDto = new LoginResponseDto(user.getUsername(), user.getNickname(), user.getProfileUrl(), "Success Login!!!");
        String result = mapper.writeValueAsString(loginResponseDto);
        response.getWriter().write(result);
    }

}

