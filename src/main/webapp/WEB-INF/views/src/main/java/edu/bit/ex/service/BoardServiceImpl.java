package edu.bit.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
   
   @Autowired
   private BoardMapper boardMapper;
   
   @Override
   public List<BoardVO> getList() {
      System.out.println("getList()..");
      
      return boardMapper.getList();
   }

   @Override
   public BoardVO get(int bid) {
       log.info("service:get()..");
       upHit(bid);
       return boardMapper.read(bid);
   }
   
   @Override
   public void modify(BoardVO boardVO) {
       log.info("service:modify()..");
       boardMapper.update(boardVO);
   }
   
   @Override
   public void remove(int bid) {
       log.info("service:remove()..");

       boardMapper.delete(bid);
   }

   @Override
   public void writeBoard(BoardVO boardVO) {
       boardMapper.insertBoard(boardVO);
   }
   
   @Override
   public void writeReply(BoardVO boardVO) {
       boardMapper.updateShape(boardVO);
       boardMapper.insertReply(boardVO);
   }

   @Override
   public void upHit(int bid) {
	   boardMapper.updateHit(bid);
   }

}