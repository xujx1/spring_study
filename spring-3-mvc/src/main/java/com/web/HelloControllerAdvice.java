package com.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HelloControllerAdvice {
    //抓捕异常
    @ExceptionHandler(NullPointerException.class)
    private void trance() {
        System.out.println("=========");
    }
}
