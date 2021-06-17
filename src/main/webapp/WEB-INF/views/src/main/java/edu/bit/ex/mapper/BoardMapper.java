package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
    List<BoardVO> getList();
    BoardVO read(int bid);
    void update(BoardVO boardVO);
    void delete(int bid);
    void insertBoard(BoardVO boardVO);
    
    // 댓글 관련
    void updateShape(BoardVO boardVO);
    void insertReply(BoardVO boardVO);
    
    // 히트 관련
    void updateHit(int bid);    

}
