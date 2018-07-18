package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.MemberMapper;
import vo.MemberVO;

@Component
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	public int insertMember(MemberVO member) {
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.insertMem(member);
	}
	
	public int updateMember(MemberVO member) {
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.updateMem(member);
	}
	
	public MemberVO selectMember(String id) {
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.selectMem(id);
	}
	
	public String checkPass(String id) {
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.checkPass(id);
	}
	
	public String checkNamebyId(String id) {
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.checkNamebyId(id);
	}
	
	public String checkName(String nick) {
		MemberMapper mapper = template.getMapper(MemberMapper.class);
		return mapper.checkName(nick);
	}
	
}
