package com.noirix.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeadRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("In HeadRequest filter!");
        HttpServletRequest castedRequest = (HttpServletRequest) servletRequest;
        String langHeader = castedRequest.getHeader("Language");
        if (StringUtils.isNotBlank(langHeader)) {
            System.out.println("language was specified: -" + langHeader);
            filterChain.doFilter(servletRequest, servletResponse);}

         else {
            System.out.println("Header was not found!");
        filterChain.doFilter(servletRequest, servletResponse);
        }}
      //  HttpServletResponse httpServletResponse =(HttpServletResponse)servletResponse;
      //  httpServletResponse.sendError(500,"/500.jsp");
      //


    @Override
    public void destroy() {

    }
}
