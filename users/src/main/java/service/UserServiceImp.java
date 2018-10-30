package service;

import java.util.List;

import dao.UserDAO;
import dto.UserDTO;

public class UserServiceImp implements UserService {
	private UserDAO dao;
	
	public UserServiceImp() {
	
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	/**사용자 등록**/
	@Override
	public void insertUserProcess(UserDTO dto) {
		dao.insertUser(dto);
	}
	
	/**아이디 중복확인**/
	@Override
	public int idCheckProcess(String u_id) {
		return dao.idCheck(u_id);
	}
	
	/**이메일 중복확인**/
	@Override
	public int mailCheckProcess(String u_mail) {
		return dao.mailCheck(u_mail);
	}
	
	

}
