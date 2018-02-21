package Project_JSP.dto;

import java.util.Date;

public class QnaView {
	private int num;
	private String id;
	private String title;
	private Date date;
	private String content;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public QnaView(int num, String id, String title, Date date, String content) {
		this.num = num;
		this.id = id;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	public QnaView() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return String.format("QnaView [num=%s, id=%s, title=%s, date=%s, content=%s]", num, id, title, date, content);
	}
}
