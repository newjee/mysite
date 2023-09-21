package com.poscodx.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"}, initParams = {
        @WebInitParam(name = "encoding", value = "utf-8")
})
public class EncodingFilter extends HttpFilter implements Filter {

    private static final long serialVersionUID = 1L;
    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        if (encoding == null) {
            encoding = "utf-8";
        }
    }


    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        request 처리

        req.setCharacterEncoding(encoding);

        chain.doFilter(req,res);

//        response 처리

    }

    public void destroy() {
    }


}