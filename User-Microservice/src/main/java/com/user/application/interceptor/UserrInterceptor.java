package com.user.application.interceptor;

import com.user.application.exception.InvalidHeaderException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;


@Component
@Slf4j
public class UserrInterceptor implements HandlerInterceptor {
    HttpHeaders headers = new HttpHeaders();

    @PostConstruct
    public void init() {
        headers.add("USER-ID", "");
        headers.add("USERNAME", "");
        headers.add("EMAIL", "");
        headers.add("MOBILE", "");
        headers.add("DEPT-ID", "");
    }

    @Override
    public boolean preHandle(HttpServletRequest request,  HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> headersMap = headers.toSingleValueMap();
        Enumeration<String> e = request.getHeaderNames();
        List<String> lst = new ArrayList<String>();
        while(e.hasMoreElements()) {
            String header = (String)e.nextElement();
            lst.add(header.toUpperCase());
        }
        headersMap.forEach((k, v) -> {
            if(!lst.contains(k))
            {
                log.error("Header validation failure");
                throw new InvalidHeaderException("Invalid header value passed");
            }
        });
        return true;
    }
}
