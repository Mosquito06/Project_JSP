package Project_JSP.service.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.RoomDao;
import Project_JSP.dto.Room;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestRoomDaoService {
	
	@Test
	public void TestSelectAvailabilityRoom() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			List<Room> list  =dao.selectAvailabilityRoom();
			
			for(Room r : list){
				System.out.println(r.toString() + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*@Test
	public void selectEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			List<Room> list  =dao.selectRoom();
			
			for(Room r : list){
				System.out.println(r.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectEventByNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			
			Room room = new Room();
			room.setRoomNum(3);
			
			Room selectRoom = dao.selectRoomByNum(room);
			System.out.println(selectRoom.toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void insertEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			
			RoomInfo roomInfo = new RoomInfo();
			roomInfo.setRoomInfoNum(2);
			
			Room room = new Room();
			room.setRoomInfoNum(roomInfo);	
			room.setRoomPrice(80000);
			
			
			dao.insertRoom(room);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void updateEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			
			RoomInfo roomInfo = new RoomInfo();
			roomInfo.setRoomInfoNum(2);
			
			Room room = new Room();
			room.setRoomNum(2);
			room.setRoomInfoNum(roomInfo);	
			room.setRoomPrice(150000);
			
			
			dao.updateRoom(room);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/*@Test
	public void deleteEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			Room room = new Room();
			room.setRoomNum(2);
			
			
			dao.deleteRoom(room);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
