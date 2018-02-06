package Project_JSP.dto;

public class Board {
	private int num;
	private int type;
	private String name;
	private String email;
	private String tel;
	private String title;
	
	public Board(int num, int type, String name, String email, String tel, String title) {
		super();
		this.num = num;
		this.type = type;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.title = title;
	}
	
	public Board() {}

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
