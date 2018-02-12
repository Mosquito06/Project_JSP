package Project_JSP.dto;

import java.util.Date;

public class Board {
	private int num;
	private int type;
	private String name;
	private String email;
	private String tel;
	private String title;
	private Date date;
	private int check;

	public int getCheck() {
		return check;
	}
	

	public Board(String name, String title, Date date, int check) {
		super();
		this.name = name;
		this.title = title;
		this.date = date;
		this.check = check;
	}
	
	


	public Board(String name, String email, String tel, String title, Date date) {
		super();
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.title = title;
		this.date = date;
	}


	public void setCheck(int check) {
		this.check = check;
	}

	public Board(int type, String name, String email, String tel, String title, Date date, int check) {
		super();
		this.type = type;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.title = title;
		this.date = date;
		this.check = check;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Board(int type, String name, String email, String tel, String title, Date date) {
		super();

		this.type = type;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.title = title;
		this.date = date;
	}

	public Board() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Board [num=" + num + ", type=" + type + ", name=" + name + ", email=" + email + ", tel=" + tel
				+ ", title=" + title + "]";
	}

}
