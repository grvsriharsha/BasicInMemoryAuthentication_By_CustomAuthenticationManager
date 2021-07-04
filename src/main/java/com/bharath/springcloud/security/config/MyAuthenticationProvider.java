package com.bharath.springcloud.security.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String userName=authentication.getName();
       String password=authentication.getCredentials().toString();

       if("tom".equals(userName) && "cruise".equals(password))
       {
          return new UsernamePasswordAuthenticationToken(userName,password, Arrays.asList());
       }
       else
       {
           throw new RuntimeException("Cred are wrong!!");
       }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
