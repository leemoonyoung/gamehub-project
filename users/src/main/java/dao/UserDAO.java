package dao;

import java.util.List;

import dto.UserDTO;

public interface UserDAO {
	//사용자 등록
	public void insertUser(UserDTO dto);
	
	//아이디 중복확인
	public int idCheck(String u_id);
	
	//이메일 중복확인
	public int mailCheck(String u_mail);
}
