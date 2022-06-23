package com.hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    String uuid;
    String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log( String message) {
        System.out.println( "[" + uuid + "]" + "[" + requestUrl + "]" + "message = " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }

}
