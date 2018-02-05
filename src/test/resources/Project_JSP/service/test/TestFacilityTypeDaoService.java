package Project_JSP.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.FacilityTypeDao;
import Project_JSP.dto.FacilityType;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestFacilityTypeDaoService {

	@Test
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
}
