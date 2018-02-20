package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.GalleryDao;
import Project_JSP.dao.RoomDao;
import Project_JSP.dto.Gallery;
import Project_JSP.dto.Room;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class GalleryDaoService implements GalleryDao {
	private static final GalleryDaoService INSTANCE = new GalleryDaoService();

	public static GalleryDaoService getInstance() {
		return INSTANCE;
	}

	private GalleryDaoService() {}
	
	@Override
	public List<Gallery> selectGallery() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);
			
			return dao.selectGallery();
		} catch (Exception e) {   
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Gallery selecGalleryByNum(Gallery gallery) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);
			return dao.selecGalleryByNum(gallery);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertGallery(Gallery gallery) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);
			dao.insertGallery(gallery);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateGallery(Gallery gallery) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);
			dao.updateGallery(gallery);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int deleteGallery(Gallery gallery) {
		int result = -1;
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);
			result = dao.deleteGallery(gallery);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Gallery> selectByGalleryType(Gallery gallery) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);
			return dao.selectByGalleryType(gallery);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
