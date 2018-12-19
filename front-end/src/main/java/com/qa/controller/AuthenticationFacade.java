package com.qa.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthentication {
 

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}