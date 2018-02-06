package Project_JSP.dto;

public class Gallery {
	private int galleryNum;
	private String galleryName;
	private String galleryContent;
	private String galleryPath;
	private String galleryType;

	public int getGalleryNum() {
		return galleryNum;
	}

	public void setGalleryNum(int galleryNum) {
		this.galleryNum = galleryNum;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	public String getGalleryContent() {
		return galleryContent;
	}

	public void setGalleryContent(String galleryContent) {
		this.galleryContent = galleryContent;
	}

	public String getGalleryPath() {
		return galleryPath;
	}

	public void setGalleryPath(String galleryPath) {
		this.galleryPath = galleryPath;
	}

	public String getGalleryType() {
		return galleryType;
	}

	public void setGalleryType(String galleryType) {
		this.galleryType = galleryType;
	}

	public Gallery(String galleryName, String galleryContent, String galleryPath, String galleryType) {
		super();
		this.galleryName = galleryName;
		this.galleryContent = galleryContent;
		this.galleryPath = galleryPath;
		this.galleryType = galleryType;
	}

	public Gallery() {
		// TODO Auto-generated constructor stub
	}
	
	

}
