package shop.allegro.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/* ajax 의 경우 http request header 에 XMLHttpRequest 라는 값이 세팅되어 요청이 오는데,
인증되지 않은 사용자가 ajax 로 리소스를 요청할 경우
"Unauthorized" 에러를 발생시키고 나머지 경우는 로그인 페이지로 리다이렉트 시켜준다  */
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {


        if("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        } else {
            response.sendRedirect("/members/login");
        }
    }
}
