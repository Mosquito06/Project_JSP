package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.ClientDao;
import Project_JSP.dao.OptionDao;
import Project_JSP.dto.Option;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class OptionDaoService implements OptionDao {
	private static final OptionDaoService INSTANCE = new OptionDaoService();

	public static OptionDaoService getInstance() {
		return INSTANCE;
	}

	private OptionDaoService() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Option> selectOption() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			return dao.selectOption();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Option selectOptionNum(Option option) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			return dao.selectOptionNum(option);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertOption(Option option) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			dao.insertOption(option);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOption(Option option) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			dao.updateOption(option);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOption(Option option) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			dao.deleteOption(option);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
