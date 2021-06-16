package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.bit.ex.vo.BoardVO;
import edu.bit.ex.vo.EmpVO;
import edu.bit.ex.vo.MemberVO;
import edu.bit.ex.vo.UserVO;

@Mapper
public interface BoardMapper {
	
	@Select("select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc")
	public List<BoardVO> getList();		
}
