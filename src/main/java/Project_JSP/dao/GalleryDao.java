package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Gallery;

public interface GalleryDao {
	public List<Gallery> selectGallery();
	public List<Gallery> selectByGalleryType(Gallery gallery);
	public Gallery selecGalleryByNum(Gallery gallery);
	public void insertGallery(Gallery gallery);
	public void updateGallery(Gallery gallery);
	public int deleteGallery(Gallery gallery);
}
 