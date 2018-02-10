package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.EventContentDao;
import Project_JSP.dao.RoomInfoDao;
import Project_JSP.dto.RoomGrade;
import Project_JSP.dto.RoomInfo;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class RoomInfoDaoService implements RoomInfoDao {
	private static final RoomInfoDaoService INSTANCE = new RoomInfoDaoService();

	public static RoomInfoDaoService getInstance() {
		return INSTANCE;
	}

	private RoomInfoDaoService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RoomInfo> selectRoomInfo() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			return dao.selectRoomInfo();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public RoomInfo selectRoomInfoByNum(RoomInfo roomInfo) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			return dao.selectRoomInfoByNum(roomInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insertRoomInfo(RoomInfo roomInfo) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			dao.insertRoomInfo(roomInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateRoomInfo(RoomInfo roomInfo) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			dao.updateRoomInfo(roomInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteRoomInfo(RoomInfo roomInfo) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			dao.deleteRoomInfo(roomInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<RoomInfo> selectViewTypeByRoomGrade(RoomGrade roomGrade) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			return dao.selectViewTypeByRoomGrade(roomGrade);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
