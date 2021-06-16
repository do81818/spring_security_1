package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.vo.MemberVO;
import edu.bit.ex.vo.UserVO;

@Mapper
public interface MemberMapper {	
	public MemberVO getMember(String username);	
}
