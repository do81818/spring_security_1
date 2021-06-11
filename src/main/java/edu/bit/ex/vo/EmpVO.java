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
    private String ename; 
    private String empno; 
    private String job;
    
    private int mgr;
    private Timestamp hiredate;
    private int sal;
    private int comm;
    
    private int enabled;

    private List<AuthVO2> authList;
                              
}