package service;

import java.util.List;

import dto.UserDTO;

public interface UserService {
	//사용자 등록
	public void insertUserProcess(UserDTO dto);
	
	//아이디 중복확인
	public int idCheckProcess(String u_id);
	
	//이메일 중복확인
	public int mailCheckProcess(String u_mail);
	
	
}
