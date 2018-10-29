package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/joinPro.do", method=RequestMethod.POST)
	public String joinPro(HttpServletRequest request) {
		UserDTO dto = new UserDTO();
		String u_mail = request.getParameter("u_mail1") +"-"+ request.getParameter("u_mail2");

		dto.setU_id(request.getParameter("u_id"));
		dto.setU_name(request.getParameter("u_name"));
		dto.setU_mail(u_mail);
		dto.setU_nick(request.getParameter("u_nick"));
		
		service.insertUserProcess(dto);
		
		return "redirect:/insform.do";
	}
}
