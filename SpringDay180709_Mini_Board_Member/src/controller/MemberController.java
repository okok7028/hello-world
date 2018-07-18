package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "memberview/joinForm";
	}
	
	@RequestMapping("/idCheck.do")
	@ResponseBody
	public String idCheck(String id) {
		if(service.checkNamebyId(id) == null) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/nickCheck.do")
	@ResponseBody
	public String nickCheck(String nick) {
		if(service.checkName(nick) == null) {
			return "true";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/joinProc.do")
	public String joinProc(MemberVO member) {
		if(service.memberValidator(member)) {
			return "memberview/joinSuccess";
		}else {
			return "memberview/joinFail";
		}
	}
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "memberview/loginForm";
	}
	
	@RequestMapping("/loginProc.do")
	public ModelAndView loginProc(String userId, String userPw, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(service.checkLogin(userId, userPw)) {
			session.setAttribute("loginId", userId);
			mv.addObject("nick", service.getNick(userId));
			mv.setViewName("memberview/loginSuccess");
		}else {
			mv.setViewName("memberview/loginFail");
		}
		return mv;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "memberview/logout";
	}
	
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(HttpSession session) {
		String id = (String)session.getAttribute("loginId");
		ModelAndView mv = new ModelAndView();
		MemberVO vo = service.getMem(id);
		mv.addObject("id", id);
		mv.addObject("name", vo.getMemberName());
		mv.addObject("nick", vo.getMemberNick());
		mv.setViewName("memberview/updateForm");
		return mv;
	}
	
	@RequestMapping("/updateProc.do")
	public String updateProc(MemberVO member, String memberPw2, HttpSession session) {
		String id = (String)session.getAttribute("loginId");
		if(service.checkLogin(id, memberPw2)) {
			if(service.updateValidator(member)) {
				session.invalidate();
				return "memberview/updateSuccess";
			}else {
				return "memberview/updateFail";
			}
		}else {
			return "memberview/updateFail";
		}
				
	}
}
