package Project_JSP.dto;

import java.util.Date;

public class Comment {
	private int num;
	private Board boardNum;
	private String content;
	private Date time;
	private String writer;
	private int order;
	private int depth;
	private int group;
	
	

	@Override
	public String toString() {
		return "Comment [num=" + num + ", boardNum=" + boardNum + ", content=" + content + ", time=" + time
				+ ", writer=" + writer + ", order=" + order + ", depth=" + depth + ", group=" + group + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Board getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Board boardNum) {
		this.boardNum = boardNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public Comment(Board boardNum, String content, Date time, String writer, int order, int depth, int group) {
		super();
		this.boardNum = boardNum;
		this.content = content;
		this.time = time;
		this.writer = writer;
		this.order = order;
		this.depth = depth;
		this.group = group;
	}
	
	

	public Comment(Board boardNum, String content, Date time, String writer) {
		super();
		this.boardNum = boardNum;
		this.content = content;
		this.time = time;
		this.writer = writer;
	}

	public Comment() {
		// TODO Auto-generated constructor stub
	}

}
