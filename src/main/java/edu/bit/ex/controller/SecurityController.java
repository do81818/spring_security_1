package edu.bit.ex.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/security/*")
@Controller
public class SecurityController {
   
    @GetMapping("/all")
    public void doAll() {
       log.info("do all can access everybody");
    }// 스프링 특성상 반환값이 void 라도 해석하는 것이 달라진다.
   /*
       @GetMapping("/all")
       public String doAll() {
          log.info("do all can access everybody");
           return "security/all";
       }
       
       과 같다.
    */

   @GetMapping("/member")
   public void doMember() {

      log.info("logined member");
   }
   
   @GetMapping("/admin")
   public void doAdmin() {

      log.info("logined admin");
   }
   
   // 403 에러 처리
   @GetMapping("/accessError")
   public void accessError(Authentication auth, Principal pi, Model model) {
       // Authentication 이란? 세션 객체 -> 즉, 세션에 있는 인증 정보에 접근할 수 있음
       
      log.info("accessError() .." + auth);
      model.addAttribute("msg", "Access Denied");
   }
   
   
}
