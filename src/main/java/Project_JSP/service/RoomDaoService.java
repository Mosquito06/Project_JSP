package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.RoomDao;
import Project_JSP.dto.Room;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class RoomDaoService implements RoomDao {
	private static final RoomDaoService INSTANCE = new RoomDaoService();

	public static RoomDaoService getInstance() {
		return INSTANCE;
	}

	private RoomDaoService() {
		super();
	}

	@Override
	public List<Room> selectRoom() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			return dao.selectRoom();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Room selectRoomByNum(Room room) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			return dao.selectRoomByNum(room);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertRoom(Room room) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			dao.insertRoom(room);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRoom(Room room) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			dao.updateRoom(room);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteRoom(Room room) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			dao.deleteRoom(room);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Room> selectAvailabilityRoom(String sDate, String eDate) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			return dao.selectAvailabilityRoom(sDate, eDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
