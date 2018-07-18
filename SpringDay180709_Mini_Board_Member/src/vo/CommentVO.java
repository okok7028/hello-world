package vo;

public class CommentVO {

	private int commentNum;
	private String writer;
	private String content;
	private String writedate;
	private int boardRef;
	private int commentRef;
	private int commentSeq;
	private int commentLevel;
	
	public CommentVO() {}

	public CommentVO(int commentNum, String writer, String content, String writedate, int boardRef, int commentRef,
			int commentSeq, int commentLevel) {
		this.commentNum = commentNum;
		this.writer = writer;
		this.content = content;
		this.writedate = writedate;
		this.boardRef = boardRef;
		this.commentRef = commentRef;
		this.commentSeq = commentSeq;
		this.commentLevel = commentLevel;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public int getBoardRef() {
		return boardRef;
	}

	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}

	public int getCommentRef() {
		return commentRef;
	}

	public void setCommentRef(int commentRef) {
		this.commentRef = commentRef;
	}

	public int getCommentSeq() {
		return commentSeq;
	}

	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}
	
	
}
