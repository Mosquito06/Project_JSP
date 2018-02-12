package Project_JSP.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.GalleryDao;
import Project_JSP.dao.OptionDao;
import Project_JSP.dto.Gallery;
import Project_JSP.dto.GalleryType;
import Project_JSP.dto.Option;
import Project_JSP.dto.SelectOption;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestOptionDaoService {

	/*@Test
	public void selectEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			List<Option> list = dao.selectOption();

			for (Option g : list) {
				System.out.println(g.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectEventByNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			
			Option option = new Option();
			option.setOptionNum(2);
			
			
			
			System.out.println(dao.selectOptionNum(option).getOptionContent());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void insertEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			
			Option option = new Option();
			option.setOptionNum(1);
			option.setOptionContent("DailyExtra Bed");
			option.setOptionPrice(40000);
			option.setSelectOption(SelectOption.NO);
			
			dao.insertOption(option);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/*@Test
	public void updateEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			
			Option option = new Option();
			option.setOptionNum(2);
			option.setOptionContent("수정");
			option.setOptionPrice(400000);
			option.setSelectOption(SelectOption.YES);
			
			dao.updateOption(option);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	@Test
	public void deleteEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			OptionDao dao = session.getMapper(OptionDao.class);
			
			Option option = new Option();
			option.setOptionNum(2);
			
			dao.deleteOption(option);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
