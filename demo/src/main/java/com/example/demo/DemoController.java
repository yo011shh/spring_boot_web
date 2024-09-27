package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller // 컨트롤러 어노테이션 명시
public class DemoController
{
@GetMapping("/hello2") // 전송 방식 GET
public String hello2(Model model) {
model.addAttribute("data1", " 안녕하세요!"); 
model.addAttribute("data2", " 홍길동님.");
model.addAttribute("data3", " 방갑습니다.");
model.addAttribute("data4", " 오늘.");
model.addAttribute("data5", " 날씨는.");
model.addAttribute("data6", " 매우 좋습니다.");// model 설정
return "hello2"; // hello.html 연결
}
@GetMapping("/hello") // 전송 방식 GET
public String hello(Model model) {
model.addAttribute("data1", " 나는"); 
model.addAttribute("data2", " 이도현");
model.addAttribute("data3", " 입니다.");
model.addAttribute("data4", " 공과");
model.addAttribute("data5", " 대학");
model.addAttribute("data6", " 생입니다");// model 설정
return "hello"; // hello.html 연결
}
@GetMapping("/about_detailed")
public String about() {
return "about_detailed";
}

} 