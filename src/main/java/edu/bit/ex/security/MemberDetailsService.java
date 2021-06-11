package edu.bit.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.MemberMapper;
import edu.bit.ex.vo.MemberUser;
import edu.bit.ex.vo.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

// principal.emp.sal = 확장하고 싶으면 UserDetailsService의 자손이 loadUserByUsername() 메소드를 구현

@Log4j
@Service
public class MemberDetailsService implements UserDetailsService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;

	// UserDetailsService를 구현하는 자손 클래스는 loadUserByUsername() 메소드를 구현해야 하는데
	// 리턴값을 UserDetails 에 맞게끔 리턴값을 돌리면 principal.emp.sal 처럼 확장을 할 수 있게 된다.
	// 첫번째 방법 UserDetails의 메소드의 의미를 알고 직접 구현하는 방법
	// 두번째 방법 UserDetails 인터페이스를 구현해둔 스프링 시큐리티의 여러 하위 클래스를 이용하는 방법
	
	// 가장 일반적으로 사용되는 방법은 여러 하위 클래스들 중에서 org.springframework.security.core.userdetails.user 클래스를 상속하는 형태이다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By MemberVO number: " + username);
		
		// username 으로 MemberVO 객체를 가져옴
		MemberVO vo = memberMapper.getMember(username);

		log.warn("queried by MemberVO mapper: " + vo);

		// 다형성을 적용하기 위해서
		return vo == null ? null : new MemberUser(vo);

	}
}