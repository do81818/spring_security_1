/**********************************/
/* Table Name: ȸ�� */
/**********************************/
CREATE TABLE users(
		username                      		VARCHAR2(20)		 NOT NULL,
		password                      		VARCHAR2(100)		 NULL ,
		enabled                       		INTEGER		 NULL 
);

COMMENT ON TABLE users is 'ȸ��';
COMMENT ON COLUMN users.username is '���̵�';
COMMENT ON COLUMN users.password is '��й�ȣ';
COMMENT ON COLUMN users.enabled is '������뿩��';


ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (username);

/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE authorities(
		username                      		VARCHAR2(20)		 NOT NULL,
		authority                     		VARCHAR2(20)		 NOT NULL
);

COMMENT ON TABLE authorities is '����';
COMMENT ON COLUMN authorities.username is 'ȸ�����̵�';
COMMENT ON COLUMN authorities.authority is '����';


ALTER TABLE authorities ADD CONSTRAINT IDX_authorities_PK PRIMARY KEY (username, authority);
ALTER TABLE authorities ADD CONSTRAINT IDX_authorities_FK0 FOREIGN KEY (username) REFERENCES users (username);

/**********************************/
/* Table Name: �׷� */
/**********************************/
CREATE TABLE groups(
		id                            		VARCHAR2(20)		 NOT NULL,
		group_name                    		VARCHAR2(20)		 NULL 
);

COMMENT ON TABLE groups is '�׷�';
COMMENT ON COLUMN groups.id is '�׷� ���̵�';
COMMENT ON COLUMN groups.group_name is '�׷� ��';


ALTER TABLE groups ADD CONSTRAINT IDX_groups_PK PRIMARY KEY (id);

/**********************************/
/* Table Name: �׷� ���� ���� */
/**********************************/
CREATE TABLE group_authorities(
		group_id                      		VARCHAR2(20)		 NOT NULL,
		authority                     		VARCHAR2(20)		 NOT NULL
);

COMMENT ON TABLE group_authorities is '�׷� ���� ����';
COMMENT ON COLUMN group_authorities.group_id is '�׷� ���̵�';
COMMENT ON COLUMN group_authorities.authority is '����';


ALTER TABLE group_authorities ADD CONSTRAINT IDX_group_authorities_PK PRIMARY KEY (group_id, authority);
ALTER TABLE group_authorities ADD CONSTRAINT IDX_group_authorities_FK0 FOREIGN KEY (group_id) REFERENCES groups (id);

/**********************************/
/* Table Name: �׷� ȸ�� ���� */
/**********************************/
CREATE TABLE group_members(
		group_id                      		VARCHAR2(20)		 NOT NULL,
		username                      		VARCHAR2(20)		 NOT NULL
);

COMMENT ON TABLE group_members is '�׷� ȸ�� ����';
COMMENT ON COLUMN group_members.group_id is '�׷� ���̵�';
COMMENT ON COLUMN group_members.username is 'ȸ�� ���̵�';


ALTER TABLE group_members ADD CONSTRAINT IDX_group_members_PK PRIMARY KEY (group_id, username);
ALTER TABLE group_members ADD CONSTRAINT IDX_group_members_FK0 FOREIGN KEY (username) REFERENCES users (username);
ALTER TABLE group_members ADD CONSTRAINT IDX_group_members_FK1 FOREIGN KEY (group_id) REFERENCES groups (id);


-- ȸ�� ������ �Է�
INSERT INTO users (username, password, enabled) VALUES ('user', 'user', 1);
INSERT INTO users (username, password, enabled) VALUES ('admin', 'admin', 1);

-- ȸ�� ���� �Է�
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

-- �׷�
INSERT INTO groups (id, group_name) VALUES ('G01', '������ �׷�');
INSERT INTO groups (id, group_name) VALUES ('G02', '����� �׷�');

-- �׷� ����
INSERT INTO group_authorities (group_id, authority) VALUES ('G01', 'ROLE_ADMIN');
INSERT INTO group_authorities (group_id, authority) VALUES ('G01', 'ROLE_USER');
INSERT INTO group_authorities (group_id, authority) VALUES ('G02', 'ROLE_USER');

-- �׷� ȸ��
INSERT INTO group_members (group_id, username) VALUES ('G01', 'admin');
INSERT INTO group_members (group_id, username) VALUES ('G02', 'user');
