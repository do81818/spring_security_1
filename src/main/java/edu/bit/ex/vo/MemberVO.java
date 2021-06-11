package edu.bit.ex.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO {
    private String username;
    private String password;
    private int enabled;

    private List<AuthVO> authList; // (MemberVO)1:N(authList) 관계 (카디널리티)
                                   // 한명의 유저가 여러개의 권한을 가질 수 있기 때문에
}