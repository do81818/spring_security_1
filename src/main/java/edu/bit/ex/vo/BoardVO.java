package edu.bit.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardVO {
    private int bid;
    private String bname;
    private String btitle;
    private String bcontent;
    private Timestamp bdate;
    private int bhit;
    private int bgroup;
    private int bstep;
    private int bindent;
}
