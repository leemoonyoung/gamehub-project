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
	
	//사용자 등록
	@Override
	public void insertUserProcess(UserDTO dto) {
		dao.insertUser(dto);
	}
	
	

}
