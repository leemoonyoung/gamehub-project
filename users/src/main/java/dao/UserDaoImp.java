package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.PageDTO;
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
	
	/**사용자 상세 조회**/
	@Override
	public UserDTO detail(String u_id) {
		return sqlSession.selectOne("user.detail",u_id);
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

	/**사용자 목록 수**/
	@Override
	public int count() {
		return sqlSession.selectOne("user.cnt");
	}

	/**사용자 목록 리스트**/
	@Override
	public List<UserDTO> list(PageDTO pv) {
		return sqlSession.selectList("user.list",pv);
	}
	
}
