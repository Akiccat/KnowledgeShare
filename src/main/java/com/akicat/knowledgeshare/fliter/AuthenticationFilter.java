package com.akicat.knowledgeshare.fliter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


public class AuthenticationFilter extends OncePerRequestFilter {
    private static final Logger ADEP_LOGGER =  LoggerFactory.getLogger(AuthenticationFilter.class);
    private Set<String> excludePaths;
    private String contentsRootPath;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
