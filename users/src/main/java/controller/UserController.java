package controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dto.PageDTO;
import dto.UserDTO;
import service.UserService;

@Controller
public class UserController {
	private UserService service;
	private PageDTO pdto; //페이징 처리 객체
	int currentPage; //현재 페이지 값 
	
	public UserController() {}

	public void setService(UserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/insform.do")
	public String insertForm() {
		return "ins_user";
	}
	
	/**사용자목록조회**/
	@RequestMapping(value = "/uList.do")
	public ModelAndView listMethod(PageDTO pv) {
		ModelAndView mav = new ModelAndView();
		int totalRecord = service.countProcess(); //테이블에 저장되어 있는 레코드 수 
		if(totalRecord >=1) {
			if(pv.getCurrentPage()==0) {//처음 페이지 
				currentPage =1;
			}else {
				currentPage = pv.getCurrentPage(); //page클릭 후 넘겨준 값
			}
		}
		pdto = new PageDTO(currentPage, totalRecord);
		mav.addObject("uList", service.listProcess(pdto));
		mav.addObject("pv",pdto);
		mav.setViewName("list_user");
		return mav;
	}//end listMethod()
	
	/**사용자 상세조회**/
	@RequestMapping(value = "/detail.do")
	public ModelAndView UserDetailMethod(int currentPage, String u_id) {
		ModelAndView mav = new ModelAndView();
		UserDTO dto = service.detailProcess(u_id);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String u_mail = dto.getU_mail();
		u_mail = u_mail.replace("-", "@"); //이메일 "-" => "@" 문자열 변환 
		
		String u_day = format.format(dto.getU_day()); //날짜 형식 변환
		
		mav.addObject("udto", service.detailProcess(u_id));
		mav.addObject("currentPage", currentPage);
		mav.addObject("u_mail",u_mail);
		mav.addObject("u_day", u_day);
		mav.setViewName("detail_user");
		return mav;
			
	}
	
	/**사용자 등록**/
	@RequestMapping(value = "/joinPro.do", method=RequestMethod.POST)
	public String joinProMethod(HttpServletRequest request) {
		UserDTO dto = new UserDTO();
		String u_mail = request.getParameter("u_mail1") +"-"+ request.getParameter("u_mail2");

		dto.setU_id(request.getParameter("u_id"));
		dto.setU_name(request.getParameter("u_name"));
		dto.setU_mail(u_mail);
		dto.setU_nick(request.getParameter("u_nick"));
		service.insertUserProcess(dto);
		
		return "redirect:/uList.do";
	}//end joinProMethod()
	
	/**아이디 중복확인**/	
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST)
	public @ResponseBody int idCheckMethod(@RequestBody String u_id) {
		int count = 0;
		count = service.idCheckProcess(u_id);
		return count;
	}//end idCheckMethod()
	
	/**이메일 중복확인**/
	@RequestMapping(value = "/mailCheck.do", method = RequestMethod.POST)
	public @ResponseBody int mailCheck(@RequestBody String u_mail) {
		int count = 0;
		count = service.mailCheckProcess(u_mail);
		return count;
	}//end mailCheck()
}
