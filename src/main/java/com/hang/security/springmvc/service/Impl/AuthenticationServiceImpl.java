package com.hang.security.springmvc.service.Impl;

import com.hang.security.springmvc.model.AuthenticationRequest;
import com.hang.security.springmvc.model.UserDto;
import com.hang.security.springmvc.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        if(authenticationRequest==null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
                ||StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("账号密码为空");
        }
        UserDto user = getUserDto(authenticationRequest.getUsername());
        if(user==null){
            throw  new RuntimeException("zhao不到该用户");
        }
        if(!(user.getPassword().equals(authenticationRequest.getPassword()))){
            throw  new RuntimeException("账号名或密码错误");
        }


        return user;
    }

    private UserDto getUserDto(String username){
        return userMap.get(username);
    }



    private Map<String,UserDto> userMap = new HashMap<>();

    {
        Set<String> authenticate1 = new HashSet<String>();
        Set<String> authenticate2 = new HashSet<String>();
        authenticate1.add("p1");
        authenticate2.add("p2");

        userMap.put("zhangsan",new UserDto("111","张三","123456","张三","123456789",authenticate1));
        userMap.put("lisi",new UserDto("222","李四","234567","李xxx","123456789",authenticate2));

    }


}
