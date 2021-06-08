package edu.bit.ex.controller;

import org.springframework.stereotype.Controller;
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
   } // 스프링 특성상 반환값이 void 라도 해석하는 것이 달라진다.
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
   
}
