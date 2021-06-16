package edu.bit.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

/*
USERNAME  NOT NULL VARCHAR2(50) 
AUTHORITY NOT NULL VARCHAR2(50) 
*/
@Log4j
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthVO {
	   private String username;
	   private String authority;	
}
