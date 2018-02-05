package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.FacilityTypeDao;
import Project_JSP.dto.FacilityType;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class FacilityTypeDaoService implements FacilityTypeDao {
	private static final FacilityTypeDaoService INSTANCE = new FacilityTypeDaoService();

	public static FacilityTypeDaoService getInstance() {
		return INSTANCE;
	}

	private FacilityTypeDaoService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<FacilityType> selectFacilityType() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			FacilityTypeDao dao = session.getMapper(FacilityTypeDao.class);
			return dao.selectFacilityType();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
