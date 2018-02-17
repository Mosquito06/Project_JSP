package Project_JSP.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.ReservationDao;
import Project_JSP.dto.Reservation;
import Project_JSP.dto.ReservationState;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class ReservationDaoService implements ReservationDao {
	private static final ReservationDaoService INSTANCE = new ReservationDaoService();

	public static ReservationDaoService getInstance() {
		return INSTANCE;
	}

	private ReservationDaoService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Reservation> selectReservation() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			return dao.selectReservation();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	@Override
	public Reservation selectReservationNum(Reservation reservation) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			return dao.selectReservationNum(reservation);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertReservation(Reservation reservation) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			dao.insertReservation(reservation);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateReservation(Reservation reservation) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			dao.updateReservation(reservation);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			dao.deleteReservation(reservation);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reservation> selectReservationDate(Reservation reservation) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			return dao.selectReservationDate(reservation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Reservation> selectReservationUser(int clientNum) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			return dao.selectReservationUser(clientNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reservation> selectReservationState(ReservationState state) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			return dao.selectReservationState(state);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reservation> selectLastReservation() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			return dao.selectLastReservation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
