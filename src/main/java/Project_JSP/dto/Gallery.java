package Project_JSP.dto;

public class Gallery {
	private int num;
	private String name;
	private String content;
	private String path;
	private GalleryType type;

	public Gallery() {}

	public int getGalleryNum() {
		return num;
	}
 
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

	public void setGalleryNum(int galleryNum) {
		this.num = galleryNum;
	}
	
	public String getGalleryName() {
		return name;
	}

	public void setGalleryName(String galleryName) {
		this.name = galleryName;
	}

	public String getGalleryContent() {
		return content;
	}

	public void setGalleryContent(String galleryContent) {
		this.content = galleryContent;
	}

	public String getGalleryPath() {
		return path;
	}

	public void setGalleryPath(String galleryPath) {
		this.path = galleryPath;
	}

	public GalleryType getGalleryType() {
		return type;
	}

	public void setGalleryType(GalleryType galleryType) {
		this.type = galleryType;
	}

	@Override
	public String toString() {
		return "Gallery [galleryNum=" + num + ", galleryName=" + name + ", galleryContent="
				+ content + ", galleryPath=" + path + ", galleryType=" + type + "]";
	}

}
