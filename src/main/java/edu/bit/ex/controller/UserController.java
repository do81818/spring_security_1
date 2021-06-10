package edu.bit.ex.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.service.UserService;
import edu.bit.ex.vo.UserVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/user/userForm")
    public void userForm() {
        log.info("userForm() .. ");
        
    }
    
    // 회원 가입이기 때문에 Post 로 데이터를 받는다
    @PostMapping("/user/addUser")
    public String addUser(UserVO userVO) {
        log.info("addUser() .. ");
        
        userService.addUser(userVO);
        
        return "redirect:/";
        
    }
}
