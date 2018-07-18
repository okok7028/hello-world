package mapper;

import vo.MemberVO;

public interface MemberMapper {

	public int insertMem(MemberVO member);
	public int updateMem(MemberVO member);
	public MemberVO selectMem(String id);
	public String checkPass(String id);
	public String checkNamebyId(String id);
	public String checkName(String nick);
}
