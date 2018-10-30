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



	/**사용자 등록**/
	@Override
	public void insertUser(UserDTO dto) {
		sqlSession.insert("user.insUser",dto);
	}
	
	/**아이디 중복확인**/
	@Override
	public int idCheck(String u_id) {	
		return sqlSession.selectOne("user.idChk",u_id);
	}

	/**이메일 중복확인**/
	@Override
	public int mailCheck(String u_mail) {
		return sqlSession.selectOne("user.mailChk",u_mail);
	}
	
}
