package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDAO;
import vo.MemberVO;

@Component
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
//	회원가입
	public boolean memberValidator(MemberVO member) {
		if( member.getMemberId()==null || member.getMemberId()=="" ||
			member.getMemberPw()==null || member.getMemberPw()=="" ||
			member.getMemberName()==null || member.getMemberName()=="" ||
			member.getMemberNick()==null || member.getMemberName()==""){
			return false;
		}else {
			dao.insertMember(member);
			return true;
		}
	}
	
	//업데이트
	public boolean updateValidator(MemberVO member) {
		if( member.getMemberId()==null || member.getMemberId()=="" ||
				member.getMemberPw()==null || member.getMemberPw()=="" ||
				member.getMemberName()==null || member.getMemberName()=="" ||
				member.getMemberNick()==null || member.getMemberName()==""){
				return false;
			}else {
				dao.updateMember(member);
				return true;
			}
	}
	
	// 회원정보 가져오기
	public MemberVO getMem(String id) {
		return dao.selectMember(id);
	}
	
	// 닉네임 가져오기
	public String getNick(String id) {
		MemberVO m = dao.selectMember(id);
		return m.getMemberNick();
	}
	
	//이름 가져오기 아이디로
	public String checkNamebyId(String id) {
		 return dao.checkNamebyId(id);
	}
	
	//이름 가져오기 닉으로
	public String checkName(String nick) {
		 return dao.checkName(nick);
	}
	
	// 로그인 성공 확인
	public boolean checkLogin(String id, String pass) {
		String passwd = dao.checkPass(id);
		if(passwd != null && pass.equals(passwd) ) {
			return true;
		}else {
			return false;
		}
	}
}
