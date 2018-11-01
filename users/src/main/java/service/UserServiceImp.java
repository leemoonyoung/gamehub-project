package service;

import java.util.List;

import dao.UserDAO;
import dto.PageDTO;
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
	
	/**사용자 상세 조회**/
	@Override
	public UserDTO detailProcess(String u_id) {
		return dao.detail(u_id);
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
	
	/**사용자 목록 수**/
	@Override
	public int countProcess() {
		return dao.count();
	}
	
	/**사용자 목록 리스트**/
	@Override
	public List<UserDTO> listProcess(PageDTO pv) {
		return dao.list(pv);
	}

}
