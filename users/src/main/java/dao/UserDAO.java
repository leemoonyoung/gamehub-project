package dao;

import java.util.List;

import dto.PageDTO;
import dto.UserDTO;

public interface UserDAO {
	//사용자 목록 수
	public int count();
	
	//사용자 목록 리스트
	public List<UserDTO> list(PageDTO pv);
	
	//사용자 상세 조회
	public UserDTO detail(String u_id);
	
	//사용자 등록
	public void insertUser(UserDTO dto);
	
	//아이디 중복확인
	public int idCheck(String u_id);
	
	//이메일 중복확인
	public int mailCheck(String u_mail);
}
