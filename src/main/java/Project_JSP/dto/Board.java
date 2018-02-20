package Project_JSP.dto;

import java.util.Date;

public class Board {
	private int num;
	private String name;
	private String email;
	private String tel;
	private String title;
	private Date date;
	private int check;
	private String path;
	private String id;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}



	public Board(String name, String email, String tel, String title, Date date, int check, String path, String id) {
		super();
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.title = title;
		this.date = date;
		this.check = check;
		this.path = path;
		this.id = id;
	}

	public Board() {
		// TODO Auto-generated constructor stub
	}

}
