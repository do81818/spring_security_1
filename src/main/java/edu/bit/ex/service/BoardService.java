package edu.bit.ex.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.BoardVO;
import edu.bit.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class BoardService {

	@Inject
	BoardMapper boardMapper;
	
    public List<BoardVO> selectBoardList() throws Exception {
		return boardMapper.getList();
    }
}
