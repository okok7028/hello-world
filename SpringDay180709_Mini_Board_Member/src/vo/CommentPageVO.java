package vo;

import java.util.List;

public class CommentPageVO {

	private List<CommentVO> commentList;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int totalPageCount;
	
	public CommentPageVO() {}

	public CommentPageVO(List<CommentVO> commentList, int currentPage, int startPage, int endPage, int totalPageCount) {
		this.commentList = commentList;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPageCount = totalPageCount;
	}

	public List<CommentVO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentVO> commentList) {
		this.commentList = commentList;
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
	
	
}
