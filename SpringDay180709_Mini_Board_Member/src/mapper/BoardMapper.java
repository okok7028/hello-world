package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import vo.BoardVO;
import vo.CommentVO;

public interface BoardMapper {

	public int insertBoard(BoardVO board); // 글작성
	public int selectMaxNum(); // 제일 윗 글번호
	public List<BoardVO> selectBoardList(@Param("startRow")int startRow, @Param("endRow")int endRow); // 글 목록
	public BoardVO selectBoard(int boardNum); // 세부글정보
	public int selectTotalCount(); // 총 게시글 수
	public int updateReply(@Param("boardRef")int boardRef, @Param("replySeq")int replySeq);
	public int updateReadCount(int boardNum); // 조회수 증가
	public int updateBoard(BoardVO board); // 글수정
	public int deleteBoard(int boardNum); // 글삭제
	
	public int insertComment(CommentVO comment); // 댓글작성
	public List<CommentVO> selectCommentList(@Param("startRow")int startRow, @Param("endRow")int endRow);
	public int selectCommentCount(int boardRef); // 총 댓글수
	
}
