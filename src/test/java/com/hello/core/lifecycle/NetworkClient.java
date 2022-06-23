package com.hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메세지");
    }

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    private void connect() {
        System.out.println("connect: " + url);
    }

    private void call(String message) {
        System.out.println("call: " + url + " message = " + message );
    }

    private void disconnect() {
        System.out.println("disconnect: " + url);
    }

    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
