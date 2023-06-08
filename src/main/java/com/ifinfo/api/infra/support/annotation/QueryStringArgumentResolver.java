package com.ifinfo.api.infra.support.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.net.URLDecoder;

@Component
public class QueryStringArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public boolean supportsParameter(final MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(QueryString.class) != null;
    }

    @Override
    public Object resolveArgument(final MethodParameter methodParameter,
                                  final ModelAndViewContainer modelAndViewContainer,
                                  final NativeWebRequest nativeWebRequest,
                                  final WebDataBinderFactory webDataBinderFactory) throws Exception {

        final HttpServletRequest request = (HttpServletRequest) nativeWebRequest.getNativeRequest();

        String queryString = request.getQueryString();
        queryString = URLDecoder.decode(queryString, "UTF-8");

        final String json = queryStringToJson(queryString);
        final Object obj = mapper.readValue(json, methodParameter.getParameterType());
        return obj;
    }


    private String queryStringToJson(String a) {

        String res = "{\"";

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) == '=') {
                res += "\"" + ":" + "\"";
            } else if (a.charAt(i) == '&') {
                res += "\"" + "," + "\"";
            } else {
                res += a.charAt(i);
            }
        }

        res += "\"" + "}";

        return res;
    }
}