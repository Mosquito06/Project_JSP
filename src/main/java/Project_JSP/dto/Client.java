package Project_JSP.dto;

import java.util.Date;

public class Client {
	private int clientNum;
	private String id;
	private String pw;
	private String nameKo;
	private String nameEn;
	private Date birth;
	private String email;
	private String phone;
	private String home;
	private String address;
	private ClientGrade clientGrade;

	public int getClientNum() {
		return clientNum;
	}

	public void setClientNum(int clientNum) {
		this.clientNum = clientNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNameKo() {
		return nameKo;
	}
	public void setNameKo(String nameKo) {
		this.nameKo = nameKo;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ClientGrade getClientGrade() {
		return clientGrade;
	}

	public void setClientGrade(ClientGrade clientGrade) {
		this.clientGrade = clientGrade;
	}

	public Client(String id, String pw, String nameKo, String nameEn, Date birth, String email, String phone,
			String home, String address, ClientGrade clientGrade) {
		super();
		this.id = id;
		this.pw = pw;
		this.nameKo = nameKo;
		this.nameEn = nameEn;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.home = home;
		this.address = address;
		this.clientGrade = clientGrade;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

}
