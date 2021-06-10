package edu.bit.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
    USERNAME NOT NULL VARCHAR2(50)  
    PASSWORD NOT NULL VARCHAR2(100) 
    ENABLED           CHAR(1)       
 */

@Getter
@Setter
@AllArgsConstructor
public class UserVO {
    private String username;
    private String password;
    private int enabled;

        public UserVO() {
            this("user", "1111", 1);
        }
}