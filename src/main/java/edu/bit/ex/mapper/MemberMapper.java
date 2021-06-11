package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.vo.MemberVO;

@Mapper
public interface MemberMapper {
    
    public MemberVO getMember(String username); // 스프링 시큐리티에서는 username 이 id로 통칭된다.
    
}