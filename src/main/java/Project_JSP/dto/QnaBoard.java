package Project_JSP.dto;

import java.util.Date;

public class QnaBoard {
	private int qnaNum;
	private String name;
	private String email;
	private String tel;
	private String title;
	private Date date;
	private ClientGrade clientGrade;
	private String path;
	private String id;
	public int getQnaNum() {
		return qnaNum;
	}
	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public ClientGrade getClientGrade() {
		return clientGrade;
	}
	public void setClientGrade(ClientGrade clientGrade) {
		this.clientGrade = clientGrade;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public QnaBoard(int qnaNum, String name, String email, String tel, String title, Date date, ClientGrade clientGrade,
			String path, String id) {
		this.qnaNum = qnaNum;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.title = title;
		this.date = date;
		this.clientGrade = clientGrade;
		this.path = path;
		this.id = id;
	}
	public QnaBoard() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return String.format(
				"QnaBoard [qnaNum=%s, name=%s, email=%s, tel=%s, title=%s, date=%s, clientGrade=%s, path=%s, id=%s]",
				qnaNum, name, email, tel, title, date, clientGrade, path, id);
	}
	
		
}
