package edu.bit.ex.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class UserService {
    
    @Autowired // = @Inject
    private BCryptPasswordEncoder passEncoder; // BCryptPasswordEncoder = 암호화 모듈 (모듈을 가져오려면 Ioc컨테이너에 생성되어있어야 한다)
    
    @Inject
    private UserMapper userMapper;
   
    @Transactional(rollbackFor = Exception.class) // @Transactional = 예외가 발생했을 경우 롤백시킨다.
    public void addUser(UserVO userVO) {
       String password = userVO.getPassword();
       String encode = passEncoder.encode(password);

       userVO.setPassword(encode);

       userMapper.insertUser(userVO);
       userMapper.insertAuthorities(userVO);
    }
}