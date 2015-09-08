--TABLE USERS--
CREATE  TABLE users (
  username VARCHAR2(45) NOT NULL ,
  password VARCHAR2(45) NOT NULL ,
  enabled NUMBER(3) DEFAULT 1 NOT NULL ,
  PRIMARY KEY (username));
------------------------------------------------------------------------------------  
--TABLE USER_ROLES--
CREATE TABLE user_roles (
  user_role_id number(10) NOT NULL,
  username varchar2(45) NOT NULL,
  role varchar2(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT uni_username_role UNIQUE (role,username)
 ,
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

-- Generate ID using sequence and trigger
CREATE SEQUENCE user_roles_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER user_roles_seq_tr
 BEFORE INSERT ON user_roles FOR EACH ROW
 WHEN (NEW.user_role_id IS NULL)
BEGIN
 SELECT user_roles_seq.NEXTVAL INTO :NEW.user_role_id FROM DUAL;
END;
/

CREATE INDEX fk_username_idx ON user_roles (username);