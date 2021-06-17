package edu.bit.ex.vo;

import java.sql.Timestamp;
/*
bid number(4) primary key,
bname VARCHAR2(20),
btitle VARCHAR2(100),
bcontent VARCHAR2(300),
bdate date default sysdate,
bhit number(4) default 0,
bgroup number(4),
bstep number(4),
bindent number(4)*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
   private int bid;
   private String bname;
   private String btitle;
   private String bcontent;
   private Timestamp bdate;
   private   int bhit;
   private int bgroup;
   private int bstep;
   private int bindent;
   
}