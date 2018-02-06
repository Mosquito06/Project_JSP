package Project_JSP.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.EventContentDao;
import Project_JSP.dto.Event;
import Project_JSP.dto.EventContent;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestEventContentDaoService {

	/*@Test
	public void selectEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			List<EventContent> list = dao.selectEventContent();

			for (EventContent e : list) {
				System.out.println(e.getEventNum().getEventNum());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/*@Test
	public void selectEventByNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			
			Event event = new Event();
			event.setEventNum(1);
			
			EventContent eventContent = new EventContent();
			eventContent.setEventNum(event);
			
			EventContent selectEventContent = dao.selectEventContentByNum(eventContent);
			System.out.println(selectEventContent.getEventContentImg());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void insertEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			
			Event event = new Event();
			event.setEventNum(1);
			
			EventContent eventContent = new EventContent();
			eventContent.setEventNum(event);
			eventContent.setEventContentImg("이벤트 내용 경로2");;
					
			
			dao.insertEventContent(eventContent);;
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	@Test
	public void updateEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			
			Event event = new Event();
			event.setEventNum(1);
			
			EventContent eventContent = new EventContent();
			eventContent.setEventNum(event);
			eventContent.setEventContentImg("이벤트 내용 경로");;
			
			dao.updateEventContent(eventContent);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*@Test
	public void deleteEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventContentDao dao = session.getMapper(EventContentDao.class);
			
			Event event = new Event();
			event.setEventNum(1);
		
			EventContent eventContent = new EventContent();
			eventContent.setEventNum(event);
			
			dao.deleteEventContent(eventContent);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
