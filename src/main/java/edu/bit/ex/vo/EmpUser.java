package edu.bit.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmpUser extends User {

    // principal.member.username principal을 확장할때 이렇게 변수명이 들어감
    private EmpVO emp;

    // 기본적으로 부모의 생성자를 호출해야만 정상적으로 작동 (username, password, authorities 필수)
    public EmpUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public EmpUser(EmpVO empVO) {
        super(empVO.getEname(), empVO.getEmpno(), getAuth(empVO));
        this.emp = empVO;
    }

    // 유저가 갖고 있는 권한 목록
    public static Collection<? extends GrantedAuthority> getAuth(EmpVO empVO) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (AuthVO2 auth : empVO.getAuthList()) {
            authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
        }

        return authorities;
    }
}
