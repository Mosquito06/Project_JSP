package Project_JSP.service.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.EventDao;
import Project_JSP.dto.Event;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestEventDaoService {

	/*@Test
	public void selectEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			List<Event> list = dao.selectEvent();

			for (Event e : list) {
				System.out.println(e.getEventName());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectEventByNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			
			Event event = new Event();
			event.setEventNum(1);
			
			Event selectEvent = dao.selectEventByNum(event);
			System.out.println(selectEvent.getEventName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	@Test
	public void insertEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			
			Event event = new Event();
			event.setEventEndDay(new Date());
			event.setEventStartDay(new Date());
					
			
			dao.insertEvent(event);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*@Test
	public void updateEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			
			Event event = new Event();
			event.setEventNum(1);
			event.setEventImg("수정 경로");
			event.setEventName("이벤트 수정 이름");
			event.setEventTitle("이벤트 수정 타이틀");	
			
			dao.updateEvent(event);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void deleteEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			EventDao dao = session.getMapper(EventDao.class);
			
			Event event = new Event();
			event.setEventNum(1);
		
			
			dao.deleteEvent(event);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
