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

    private EmpVO emp;

    public EmpUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public EmpUser(EmpVO empVO) {
        super(empVO.getEname(), empVO.getEmpno(), getAuth(empVO));
        this.emp = empVO;
    }

    
    public static Collection<? extends GrantedAuthority> getAuth(EmpVO empVO) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new SimpleGrantedAuthority(empVO.getAuthority()));

        return authorities;
    }
}
