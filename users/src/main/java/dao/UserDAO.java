package dao;

import java.util.List;

import dto.UserDTO;

public interface UserDAO {
	//사용자 등록
	public void insertUser(UserDTO dto);
}
