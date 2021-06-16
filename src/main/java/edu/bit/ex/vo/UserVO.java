package edu.bit.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserVO {

	private String username;
	private String password;
	private int enabled;

	public UserVO() {
		this("user", "1111", 1);
	}
}
