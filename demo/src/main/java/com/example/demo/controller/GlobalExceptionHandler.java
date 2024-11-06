package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler  {

    // NumberFormatException 처리
    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException(NumberFormatException ex, Model model) {
        model.addAttribute("error", "잘못된 매개변수가 전달되었습니다. 올바른 숫자 값을 입력하세요.");
        return "/error_page/article_str_error"; // 새롭게 추가한 에러 페이지로 연결
    }

   
    
}