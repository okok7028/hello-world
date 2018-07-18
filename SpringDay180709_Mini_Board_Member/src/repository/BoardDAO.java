package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BoardMapper;
import vo.BoardVO;
import vo.CommentVO;

@Component
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	public int insertBoard(BoardVO board) {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.insertBoard(board);
	}
	
	public int selectMaxNum() {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.selectMaxNum();
	}
	
	public List<BoardVO> selectBoardList(int startRow, int endRow){
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.selectBoardList(startRow, endRow);
	}
	
	public BoardVO selectBoard(int boardNum) {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.selectBoard(boardNum);
	}
	
	public int selectTotalCount() {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.selectTotalCount();
	}
	
	public int updateReply(int boardRef, int replySeq) {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.updateReply(boardRef, replySeq);
	}
	
	public int updateReadCount(int boardNum) {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.updateReadCount(boardNum);
	}
	
	public int updateBoard(BoardVO board) {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.updateBoard(board);
	}
	
	public int deleteBoard(int boardNum) {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.deleteBoard(boardNum);
	}
	
	public int insertComment(CommentVO comment) {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.insertComment(comment);
	}
	
	public List<CommentVO> selectCommentList(int startRow, int endRow){
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.selectCommentList(startRow, endRow);
	}
	
	public int selectCommentCount(int boardRef) {
		BoardMapper mapper = template.getMapper(BoardMapper.class);
		return mapper.selectCommentCount(boardRef);
	}
}
