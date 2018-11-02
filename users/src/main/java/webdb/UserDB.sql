1. User(사용자 등록)

CREATE TABLE Mems(
	u_id varchar2(20) NOT NULL UNIQUE,
	u_name varchar2(30) NOT NULL,
	u_mail varchar2(70) NOT NULL UNIQUE,
	u_nick varchar2(60),
	u_day date NOT NULL
	);

*사용자 속성에서 이메일 max 50이지만 뒤에 메일 주소 길이로 인한 추가하여
70으로 지정
	
*오라클에서 index가 필요할때 (시퀀스 같이 생성)	
u_no number primary key,

create sequence Mems_seq
start with 1
increment by 1
nocache
nocycle;	

select * from Mems;
drop table Mems;	
drop sequence Mems_seq;

*페이징 처리 하기 위한 쿼리문
select b.*
from(select rownum as rm, a.*
	 from(select * from Mems
	  	  order by u_day desc) a)b
where b.rm>=1 and b.rm<=5