package com.hang.security.springmvc.interceptor;

import com.hang.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SimpleAuthenticateInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (obj == null) {

            returnMsg(response, "请登录!");
        }
        UserDto userDto = (UserDto) obj;
        String URL = request.getRequestURI();
        if (userDto.getAuthentices().contains("p1") && URL.contains("r/r1")) {
            return true;
        } else if (userDto.getAuthentices().contains("p2") && URL.contains("r/r2")){
            return true;
        }
        response.setCharacterEncoding("GBK");
        returnMsg(response,"你没有权限登录该网页！");
        return false;

    }

    private void returnMsg(HttpServletResponse response, String msg) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.print(msg);
        printWriter.close();
        response.flushBuffer();
    }
}
