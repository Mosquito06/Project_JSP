package Project_JSP.dto;

import java.util.Date;

public class QnaReply {
	private int num;
	private int qnaNum;
	private String content;
	private Date time;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getQnaNum() {
		return qnaNum;
	}
	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
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
	public QnaReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaReply(int num, int qnaNum, String content, Date time) {
		super();
		this.num = num;
		this.qnaNum = qnaNum;
		this.content = content;
		this.time = time;
	}
	@Override
	public String toString() {
		return String.format("QnaReply [num=%s, qnaNum=%s, content=%s, time=%s]", num, qnaNum, content, time);
	}
	
	
	
	
}
