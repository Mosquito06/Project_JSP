package Project_JSP.dto;

import java.util.Date;

public class QnaView {
	private int num;
	private String id;
	private String name;
	private String title;
	private String email;
	private String tel;
	private ClientGrade clientGrade;
	private Date date;
	private String content;
	public QnaView() {
		// TODO Auto-generated constructor stub
	}
	public QnaView(int num, String id, String name, String title, String email, String tel, ClientGrade clientGrade,
			Date date, String content) {
		this.num = num;
		this.id = id;
		this.name = name;
		this.title = title;
		this.email = email;
		this.tel = tel;
		this.clientGrade = clientGrade;
		this.date = date;
		this.content = content;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public ClientGrade getClientGrade() {
		return clientGrade;
	}
	public void setClientGrade(ClientGrade clientGrade) {
		this.clientGrade = clientGrade;
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
	@Override
	public String toString() {
		return String.format(
				"QnaView [num=%s, id=%s, name=%s, title=%s, email=%s, tel=%s, clientGrade=%s, date=%s, content=%s]",
				num, id, name, title, email, tel, clientGrade, date, content);
	}
	
	

}
