package edu.bit.ex.vo;

import java.sql.Timestamp;
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
public class EmpVO {
    private String empno;
    private String ename;
    private String job;
    private Timestamp hiredate;
    private int sal;
    private int comm;
    private int deptno;
    
    public String getAuthority() {
        if(getJob().toUpperCase().contains("MANAGER"))
            return "ROLE_ADMIN";
        else
            return "ROLE_USER";
    }
}