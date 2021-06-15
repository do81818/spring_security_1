package edu.bit.ex.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.jdbc.support.SQLErrorCodes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class TxService {

    @Inject
    private UserMapper userMapper;

    // 정상 동작
    public void txTest1() {
        log.info("txTest1() .. ");

        // 데이터를 지울때는 자식부터 지우기
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(user);
    }

    // 일부러 에러를 냄
    public void txTest2() {
        log.info("txTest2() .. ");

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(null);
    }

    @Transactional
    public void txTest3() {
        log.info("txTest3() .. ");

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");

        userMapper.insertUser(user);

        user.setUsername("efg");
        user.setPassword("2222");

        userMapper.insertUser(null);
    }

    // uncheckedExeption(롤백 함)
    @Transactional
    public void txTest4() {
        log.info("txTest4() .. ");

        userMapper.deleteAuthorities();
        userMapper.deleteUsers();

        throw new RuntimeException("RuntimeException for rollback");
    }

    // CheckedExeption 테스트(롤백 안함)
    // txTest4 처럼 롤백이 안되는 이유
    // CheckedException은 컴파일단계에서 발생하므로 기본적으로 예외처리를 해야함
    // 예외처리를 한다? -> 따로 트랜잭션 처리가 되지 않음
    @Transactional
    public void txTest5() throws SQLException {
       
       userMapper.deleteAuthorities();
       userMapper.deleteUsers();

       throw new SQLException("SQLException for rollback");
    }
    
    // CheckedException을 롤백 시키고 싶다면
    // rollbackFor 라는 옵션을 사용해서 지정하면 트랜잭션 처리가 가능하도록 제공함
    @Transactional(rollbackFor = SQLException.class)
    public void txTest6() throws SQLException {
       
       userMapper.deleteAuthorities();
       userMapper.deleteUsers();

       throw new SQLException("SQLException for rollback");
    }
    
}