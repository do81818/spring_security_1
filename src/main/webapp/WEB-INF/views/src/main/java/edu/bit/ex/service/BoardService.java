package edu.bit.ex.service;

import java.util.List;


import edu.bit.ex.vo.BoardVO;

public interface BoardService {
    List<BoardVO> getList();

    BoardVO get(int bid);

    void modify(BoardVO boardVO);

    void remove(int bid);
    
    void writeBoard(BoardVO boardVO);

    void writeReply(BoardVO boardVO);

    void upHit(int bid);
}
