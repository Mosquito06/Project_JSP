package Project_JSP.service;

import java.util.Date;
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
	public int insertRoom(Room room) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			int result = dao.insertRoom(room);
			session.commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			
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

	@Override
	public List<Room> selectAvailabilityRoomByRoomNameAndDate(String roomName, String sDate, String eDate) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			return dao.selectAvailabilityRoomByRoomNameAndDate(roomName, sDate, eDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Room> selectRoomToReservation(Date sDate, Date eDate, String roomGrade, String roomName, String  viewType, String bedType){
			try (SqlSession session = MySqlSessionFactory.openSession()) {
				RoomDao dao = session.getMapper(RoomDao.class);
				return dao.selectRoomToReservation(sDate, eDate, roomGrade, roomName, viewType, bedType);

			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
	}

	@Override
	public List<Room> selectRoombyGrade(String roomGrade) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			return dao.selectRoombyGrade(roomGrade);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Room> selectRoombyGradeAndName(String roomGrade, String roomName) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomDao dao = session.getMapper(RoomDao.class);
			return dao.selectRoombyGradeAndName(roomGrade, roomName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
