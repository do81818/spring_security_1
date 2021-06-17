package edu.bit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/**")
public class BoardController {
   
   @Autowired
   private BoardService boardService;   
   
   @GetMapping("/list")
   public String list(Model model) {
      log.info("list()...");
      log.info(boardService.getList());
      
      model.addAttribute("list", boardService.getList());
      
      return "list";
   }   
   
   @GetMapping("/content_view")
   public String content_view(BoardVO boardVO, Model model) {
       log.info("content_view()...");
       // boardService.upHit(boardVO.getBid());
       model.addAttribute("content_view", boardService.get(boardVO.getBid()));

       return "content_view";
   }
   
   
   @PostMapping("/modify")
   public String modify(BoardVO boardVO, Model model) {
       log.info("modify()...");
       
       boardService.modify(boardVO);

       return "redirect:list";
   }
   
   
   @GetMapping("/delete")
   public String delete(BoardVO boardVO, Model model) {
       log.info("delete()...");
       
       boardService.remove(boardVO.getBid());

       return "redirect:list";
   }
   
   @GetMapping("/write_view")
   public String write_view() {
       log.info("write_view()...");
       
       return "write_view";
   }
   
   @PostMapping("/write")
   public String write(BoardVO boardVO) {
       log.info("write()...");
       
       boardService.writeBoard(boardVO);
       
       return "redirect:list";
   }
   
   @GetMapping("/reply_view")
   public String reply_view(BoardVO boardVO, Model model) {
       log.info("reply_view()...");
       model.addAttribute("reply_view", boardService.get(boardVO.getBid()));
       
       return "reply_view";
   }
   
   @PostMapping("/reply")
   public String reply(BoardVO boardVO) {
       log.info("reply()...");
       
       boardService.writeReply(boardVO);
       
       return "redirect:list";
   } 
   
  
}
