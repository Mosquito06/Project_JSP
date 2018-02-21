package Project_JSP.dto;
 
public class ActivityContent {
	private int num;
	private String content;
	private String imgPath;

	public ActivityContent(int num) {
		super();
		this.num = num;
	}

	public ActivityContent(int num, String content, String imgPath) {
		this.num = num;
		this.content = content;
		this.imgPath = imgPath;
	}
	
	public ActivityContent() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "ActivityContent [num=" + num + ", content=" + content + ", imgPath=" + imgPath + "]";
	}

}
