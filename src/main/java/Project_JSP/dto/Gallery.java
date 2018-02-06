package Project_JSP.dto;

public class Gallery {
	private int galleryNum;
	private String galleryName;
	private String galleryContent;
	private String galleryPath;
	private GalleryType galleryType;

	public Gallery() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public GalleryType getGalleryType() {
		return galleryType;
	}

	public void setGalleryType(GalleryType galleryType) {
		this.galleryType = galleryType;
	}

	@Override
	public String toString() {
		return "Gallery [galleryNum=" + galleryNum + ", galleryName=" + galleryName + ", galleryContent="
				+ galleryContent + ", galleryPath=" + galleryPath + ", galleryType=" + galleryType + "]";
	}

}
