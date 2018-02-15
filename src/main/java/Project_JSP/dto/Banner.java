package Project_JSP.dto;

public class Banner {
	private int no;
	private String linkPath;
	private String imgPath;
	
	public Banner() {}

	public Banner(int no, String linkPath, String imgPath) {
		this.no = no;
		this.linkPath = linkPath;
		this.imgPath = imgPath;
	}

	public Banner(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getLinkPath() {
		return linkPath;
	}

	public void setLinkPath(String linkPath) {
		this.linkPath = linkPath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	
}
