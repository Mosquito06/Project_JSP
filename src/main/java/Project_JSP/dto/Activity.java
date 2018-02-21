package Project_JSP.dto;

public class Activity {
	private int num;
	private String name;
	private String introduce;
	private String type;
	private String imgPath;
	public Activity(int num, String name, String introduce, String type, String imgPath) {
		super();
		this.num = num;
		this.name = name;
		this.introduce = introduce;
		this.type = type;
		this.imgPath = imgPath;
	}
	
	public Activity() {}
	
	public Activity(String type) {
		super();
		this.type = type;
	}
	public Activity(int num) {
		super();
		this.num = num;
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
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Activity [num=" + num + ", name=" + name + ", introduce=" + introduce + ", type=" + type + ", imgPath="
				+ imgPath + "]";
	}
	
}
