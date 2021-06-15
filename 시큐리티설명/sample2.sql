create table users(
	username varchar2(50) not null primary key,
	password varchar2(100) not null,
	enabled char(1) DEFAULT '1'
);
create table authorities (
	username varchar2(50) not null,
	authority varchar2(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

commit;

insert into users (username,password) values('user','user');
insert into users (username,password) values('member','member');
insert into users (username,password) values('admin','admin');

commit;

insert into AUTHORITIES (username,AUTHORITY) values('user','ROLE_USER');
insert into AUTHORITIES (username,AUTHORITY) values('member','ROLE_MANAGER');
insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_MANAGER');
insert into AUTHORITIES (username,AUTHORITY) values('admin','ROLE_ADMIN');

commit;