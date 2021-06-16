package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.bit.ex.vo.UserVO;

public interface UserMapper {

	@Select("select * from users where username=#{username} and password=#{password}")
	public UserVO getUser(UserVO userVO);
	
	@Insert("insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
	public int insertUser(UserVO userVO);

	@Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_USER')")
	public void insertAuthorities(UserVO UserVO);

	@Delete("delete from users")
	public void deleteUsers();
	
	@Delete("delete from AUTHORITIES")
	public void deleteAuthorities();
	
}
