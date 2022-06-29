package com.example.websockettest.security.filter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormLoginFilter extends UsernamePasswordAuthenticationFilter {
    final private ObjectMapper objectMapper;

    public FormLoginFilter(final AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest;
        try {  //http 애플리케이션 Json으로 넘어오는 정보를 뽑아서 확인한다.
            //objectMapper를 통해서 Json을 자바 형태로 전환해준다.
            JsonNode requestBody = objectMapper.readTree(request.getInputStream());
            String username = requestBody.get("username").asText();
            String password = requestBody.get("password").asText();
            authRequest = new UsernamePasswordAuthenticationToken(username, password);
            //objectMapper에서 받아온 username과 password를 토큰으로 생성해준다.
        } catch (Exception e) {
            throw new RuntimeException("userId, password 입력이 필요합니다. (JSON)");
        }

        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
        // 만든 토큰으로 authenticate요청을 보낸다.
    }
}
