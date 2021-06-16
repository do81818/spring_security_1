package edu.bit.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.EmpMapper;
import edu.bit.ex.vo.EmpUser;
import edu.bit.ex.vo.EmpVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class EmpDetailsService implements UserDetailsService {

	@Setter(onMethod_ = @Autowired)
	private EmpMapper empMapper;

	//스프링 시큐리티가 지가 적당 할때 호출
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("Load User By EmpVO number " + username);
		
		EmpVO vo = empMapper.getEmp(username);     

		log.warn("queried by MemberVO mapper: " + vo);

		return vo == null ? null : new EmpUser(vo);

	}
}