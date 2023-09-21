package com.poscodx.mysite.security;

import com.poscodx.mysite.vo.UserVo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        if (!supportsParameter(parameter)) {
            return WebArgumentResolver.UNRESOLVED;
        }

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = request.getSession();

        return session.getAttribute("authUser");
    }


    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        AuthUser authUser = parameter.getParameterAnnotation(AuthUser.class);

        //@AuthUser 없으면
        if (authUser == null) {
            return false;
        }
        //paramType 검증 (UserVo)
        if (!parameter.getParameterType().equals(UserVo.class)) {
            return false;
        }

        return true;
    }
}
