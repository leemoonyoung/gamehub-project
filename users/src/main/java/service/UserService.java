package service;

import java.util.List;

import dto.PageDTO;
import dto.UserDTO;

public interface UserService {
	//사용자 목록 수
	public int countProcess();
	
	//사용자 목록 리스트
	public List<UserDTO> listProcess(PageDTO pv);
	
	//사용자 상세 조회
	public UserDTO detailProcess(String u_id);
	
	//사용자 등록
	public void insertUserProcess(UserDTO dto);
	
	//아이디 중복확인
	public int idCheckProcess(String u_id);
	
	//이메일 중복확인
	public int mailCheckProcess(String u_mail);
	
	
}
