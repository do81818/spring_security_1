package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.vo.EmpVO;
import edu.bit.ex.vo.MemberVO;

@Mapper
public interface EmpMapper {
    
    public EmpVO getEmp(String ename);
    
}