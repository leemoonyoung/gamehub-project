package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.UserDTO;

public class UserDaoImp implements UserDAO {
	SqlSessionTemplate sqlSession; //mybatis 연동 객체 선언
	
	public UserDaoImp() {
		
	}
	
	

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}



	//사용자 등록
	@Override
	public void insertUser(UserDTO dto) {
		sqlSession.insert("user.insUser",dto);
	}
	
}
