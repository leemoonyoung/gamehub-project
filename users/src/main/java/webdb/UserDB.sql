1. User(사용자 등록)
u_no number primary key,
CREATE TABLE Mems(
	u_id varchar2(20) NOT NULL UNIQUE,
	u_name varchar2(20) NOT NULL,
	u_mail varchar2(50) NOT NULL UNIQUE,
	u_nick varchar2(20),
	u_day date
	);

create sequence Mems_seq
start with 1
increment by 1
nocache
nocycle;	
123
select * from Mems;
drop table Mems;	
drop sequence Mems_seq;