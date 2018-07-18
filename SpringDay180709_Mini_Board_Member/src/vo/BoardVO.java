package vo;

public class BoardVO {

	private int boardNum;
	private String title;
	private String writer;
	private String content;
	private int readCount;
	private String writedate;
	private int boardRef;
	private int replySeq;
	private int replyLevel;
	
	public BoardVO() {}

	public BoardVO(int boardNum, String title, String writer, String content, int readCount, String writedate,
			int boardRef, int replySeq, int replyLevel) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.readCount = readCount;
		this.writedate = writedate;
		this.boardRef = boardRef;
		this.replySeq = replySeq;
		this.replyLevel = replyLevel;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
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

	public int getReplySeq() {
		return replySeq;
	}

	public void setReplySeq(int replySeq) {
		this.replySeq = replySeq;
	}

	public int getReplyLevel() {
		return replyLevel;
	}

	public void setReplyLevel(int replyLevel) {
		this.replyLevel = replyLevel;
	}

	
}
