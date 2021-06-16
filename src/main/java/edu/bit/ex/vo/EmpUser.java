package edu.bit.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpUser extends User {
	
	private EmpVO emp;
	
	public EmpUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public EmpUser(EmpVO empVO) {
		super(empVO.getEname(), empVO.getEmpno(), getAuth(empVO)); // Sting, String 형식이어서 일단 empno를 String으로 바꿔줬는데 될지..?
		this.emp = empVO;
		
	}
	
	// 권한이 두개 이상일때 적용하려고 만드는 함수
	//(현재 만들어놓은 emp authority에는 한개씩만 넣어서 상관없지만 위에 함수 오버라이딩하는게 Collection으로 들어가야하기 때문에 정의해줘야함)
	private static Collection<? extends GrantedAuthority> getAuth(EmpVO empVO) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
		authorities.add(new SimpleGrantedAuthority(empVO.getAuthority()));
	     
		return authorities;
	}
}