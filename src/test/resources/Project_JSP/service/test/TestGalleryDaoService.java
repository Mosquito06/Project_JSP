package Project_JSP.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.GalleryDao;
import Project_JSP.dao.RoomInfoDao;
import Project_JSP.dto.BedType;
import Project_JSP.dto.Gallery;
import Project_JSP.dto.GalleryType;
import Project_JSP.dto.RoomGrade;
import Project_JSP.dto.RoomInfo;
import Project_JSP.dto.ViewType;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestGalleryDaoService {

	/*@Test
	public void selectEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);
			List<Gallery> list = dao.selectGallery();

			for (Gallery g : list) {
				System.out.println(g.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectEventByNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);

			Gallery gallery = new Gallery();
			gallery.setGalleryNum(3);

			Gallery selectGallery = dao.selecGalleryByNum(gallery);
			System.out.println(selectGallery.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void insertEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);

			Gallery gallery = new Gallery();
			gallery.setGalleryNum(2);
			gallery.setGalleryContent("내용입닌다.");
			gallery.setGalleryName("갤러리 이름");
			gallery.setGalleryPath("갤러리 경로입니다.");
			gallery.setGalleryType(GalleryType.ALL);

			dao.insertGallery(gallery);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/*@Test
	public void updateEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);

			Gallery gallery = new Gallery();
			gallery.setGalleryNum(2);
			gallery.setGalleryContent("내용 수정입닌다.");
			gallery.setGalleryName("갤러리 수정 이름");
			gallery.setGalleryPath("갤러리 경로 수정입니다.");
			gallery.setGalleryType(GalleryType.DINING);

			dao.updateGallery(gallery);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/*@Test
	public void deleteEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			GalleryDao dao = session.getMapper(GalleryDao.class);

			Gallery gallery = new Gallery();
			gallery.setGalleryNum(2);

			dao.deleteGallery(gallery);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
