package vo;

import java.util.List;

public class BoardPageVO {

	private List<BoardVO> boardList;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int totalPageCount;
	private int number;
	
	public BoardPageVO() {}
	//전체 게시판글 페이징
	public BoardPageVO(List<BoardVO> boardList, int currentPage, int startPage, int endPage, int totalPageCount, int number) {
		
		this.boardList = boardList;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPageCount = totalPageCount;
		this.number=number;
	}
	public List<BoardVO> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
