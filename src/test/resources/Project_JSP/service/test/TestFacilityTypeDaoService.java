package Project_JSP.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.FacilityTypeDao;
import Project_JSP.dto.FacilityType;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestFacilityTypeDaoService {

	/*@Test
	public void selectacilityType() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			FacilityTypeDao dao = session.getMapper(FacilityTypeDao.class);
			List<FacilityType> list = dao.selectFacilityType();

			for (FacilityType f : list) {
				System.out.println(f.getFacilityTypeName());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectFacilityTypeByNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			FacilityTypeDao dao = session.getMapper(FacilityTypeDao.class);
			
			FacilityType facilityType = new FacilityType();
			facilityType.setFacilityTypeNum(1);
			
			FacilityType selectFacilityType = dao.selectFacilityTypeByNum(facilityType);
			System.out.println(selectFacilityType.getFacilityTypeName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void insertFacilityType() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			FacilityTypeDao dao = session.getMapper(FacilityTypeDao.class);
			
			FacilityType facilityType = new FacilityType();
			facilityType.setFacilityTypeNum(5);
			facilityType.setFacilityTypeName("비즈니스센터");
			
			
			dao.insertFacilityType(facilityType);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void updateFacilityType() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			FacilityTypeDao dao = session.getMapper(FacilityTypeDao.class);
			
			FacilityType facilityType = new FacilityType();
			facilityType.setFacilityTypeNum(5);
			facilityType.setFacilityTypeName("라운지 에스");
			
			dao.updateFacilityType(facilityType);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void deleteFacilityType() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			FacilityTypeDao dao = session.getMapper(FacilityTypeDao.class);
			
			FacilityType facilityType = new FacilityType();
			facilityType.setFacilityTypeNum(5);
			
			dao.deleteFacilityType(facilityType);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
