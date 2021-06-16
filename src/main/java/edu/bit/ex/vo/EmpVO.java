package edu.bit.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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