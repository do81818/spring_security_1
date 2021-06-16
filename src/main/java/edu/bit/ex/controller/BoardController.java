package edu.bit.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.service.LoginService;
import edu.bit.ex.vo.MemberVO;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	@RequestMapping("/list")
	public String list(HttpSession session,Model model) throws Exception{
		System.out.println("list()");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		/* ù��° ���
		if(member == null) {
			System.out.println("������ǰ� ����");
			return "redirect:/";
		}*/
		
		model.addAttribute("list", boardService.selectBoardList());
		return "board/list";
	}
}
