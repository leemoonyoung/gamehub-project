package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.UserDTO;
import service.UserService;

@Controller
public class UserController {
	private UserService service;
	
	public UserController() {}

	public void setService(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/index.do")
	public String indexForm() {
		return "index";
	}
	
	@RequestMapping(value = "/insform.do")
	public String insertForm() {
		return "ins_user";
	}
	
	/**사용자 등록**/
	@RequestMapping(value = "/joinPro.do", method=RequestMethod.POST)
	public String joinPro(HttpServletRequest request) {
		UserDTO dto = new UserDTO();
		String u_mail = request.getParameter("u_mail1") +"-"+ request.getParameter("u_mail2");

		dto.setU_id(request.getParameter("u_id"));
		dto.setU_name(request.getParameter("u_name"));
		dto.setU_mail(u_mail);
		dto.setU_nick(request.getParameter("u_nick"));
		System.out.println(u_mail);
		service.insertUserProcess(dto);
		
		return "redirect:/insform.do";
	}
	
	/**아이디 중복확인**/	
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	public @ResponseBody int idCheck(@RequestBody String u_id) {
		int count = 0;
		count = service.idCheckProcess(u_id);
		return count;
	}
	
	/**이메일 중복확인**/
	@RequestMapping(value = "/mailCheck.do", method = RequestMethod.POST)
	public @ResponseBody int mailCheck(@RequestBody String u_mail) {
		int count = 0;
		
		count = service.mailCheckProcess(u_mail);
		return count;
	}
}
