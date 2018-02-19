package Project_JSP.dto;

public class Gallery {
	private int num;
	private String name;
	private String content;
	private String path;
	private GalleryType type;

	public Gallery() {}

	public Gallery(int num) {
		this.num = num;
	}

	public Gallery(int num, String name, String content, String path, GalleryType type) {
		this.num = num;
		this.name = name;
		this.content = content;
		this.path = path;
		this.type = type;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public GalleryType getType() {
		return type;
	}

	public void setType(GalleryType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Gallery [galleryNum=" + num + ", galleryName=" + name + ", galleryContent="
				+ content + ", galleryPath=" + path + ", galleryType=" + type + "]";
	}

}
