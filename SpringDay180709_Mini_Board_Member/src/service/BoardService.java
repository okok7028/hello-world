package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BoardDAO;
import repository.MemberDAO;
import vo.BoardPageVO;
import vo.BoardVO;
import vo.CommentPageVO;
import vo.CommentVO;
import vo.MemberVO;

@Component
public class BoardService {

	private static final int PAGE_PER_COUNT = 5; 
	private static final int PAGE_BLOCK_COUNT = 5;
	private static final int COMMENT_PER_COUNT = 6;
	private static final int COMMENT_BLOCK_COUNT = 5;
	
	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private MemberDAO mdao;
	
	public BoardPageVO makeBoardPage(int currentPage) {
		//총 페이지 수 
		int totalBoardCount = dao.selectTotalCount();
		int totalPageCount = totalBoardCount/PAGE_PER_COUNT;
		if(totalBoardCount%PAGE_PER_COUNT != 0) totalPageCount++;
		//게시판 글번호
		int number = totalBoardCount-(currentPage-1)*PAGE_PER_COUNT;
		
		// 목록에 출력할 게시글 
		int startRow = (currentPage-1)*PAGE_PER_COUNT+1;
		int endRow = currentPage*PAGE_PER_COUNT;
		List<BoardVO> boardList = dao.selectBoardList(startRow, endRow);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//화면 하단의 페이지 링크중 시작 페이지
		int startPage = (currentPage-1)/PAGE_BLOCK_COUNT*PAGE_BLOCK_COUNT+1;
		
		//화면 하단의 페이지 링크중 끝 페이지
		int endPage = startPage+PAGE_BLOCK_COUNT-1;
		if(endPage>totalPageCount) endPage = totalPageCount;
		
		return new BoardPageVO(boardList, currentPage, startPage, endPage, totalPageCount, number);
	}
	
	public CommentPageVO makeCommentPage(int currentPage) {
		//총 페이지 수 
				int totalBoardCount = dao.selectTotalCount();
				int totalPageCount = totalBoardCount/PAGE_PER_COUNT;
				if(totalBoardCount%PAGE_PER_COUNT != 0) totalPageCount++;
				
				// 목록에 출력할 게시글 
				int startRow = (currentPage-1)*PAGE_PER_COUNT+1;
				int endRow = currentPage*PAGE_PER_COUNT;
				List<CommentVO> commentList = dao.selectCommentList(startRow, endRow);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//화면 하단의 페이지 링크중 시작 페이지
				int startPage = (currentPage-1)/PAGE_BLOCK_COUNT*PAGE_BLOCK_COUNT+1;
				
				//화면 하단의 페이지 링크중 끝 페이지
				int endPage = startPage+PAGE_BLOCK_COUNT-1;
				if(endPage>totalPageCount) endPage = totalPageCount;
				
				return new CommentPageVO(commentList, currentPage, startPage, endPage, totalPageCount);
	}
	
	public int write(BoardVO board, int num) {
		int number = 1;
		if((Integer)dao.selectMaxNum() != 0) {
			number = dao.selectMaxNum()+1;
		}
		
		int boardRef = board.getBoardRef();
		int replySeq = board.getReplySeq();
		int replyLevel = board.getReplyLevel();
		if(num != 0) { // 답글
			dao.updateReply(boardRef, replySeq);
			replySeq++; replyLevel++;
		}else { //새글
			boardRef=number;
			replySeq=0;
			replyLevel=0;
		}
		board.setReadCount(0);
		board.setBoardRef(boardRef);
		board.setReplySeq(replySeq);
		board.setReplyLevel(replyLevel);
		dao.insertBoard(board);
		return board.getBoardNum(); // board-mapper.xml insertBoard 속성에 key값 설정
	}
	
	public BoardVO read(int boardNum) {
		if(dao.updateReadCount(boardNum) > 0) {
			return dao.selectBoard(boardNum);
		}else {
			return null;
		}
	}
	
	public BoardVO readWithoutCount(int boardNum) {
		return dao.selectBoard(boardNum);
	}
	
	public boolean modify(BoardVO board) {
		if(dao.updateBoard(board)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(int boardNum) {
		if(dao.deleteBoard(boardNum)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkPass(String id, String pass) {
		String passwd = mdao.checkPass(id);
		if(passwd != null && pass.equals(passwd) ) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getNick(String id) {
		MemberVO m = mdao.selectMember(id);
		return m.getMemberNick();
	}
}
