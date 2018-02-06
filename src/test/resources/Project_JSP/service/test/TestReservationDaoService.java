package Project_JSP.service.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.ReservationDao;
import Project_JSP.dto.Reservation;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestReservationDaoService {

/*	@Test
	public void selectReservation() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			List<Reservation> list = dao.selectReservation();

			for (Reservation f : list) {
				System.out.println(f.getReservationNum());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

	/*@Test
	public void selectReservationNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			Reservation reservation = new Reservation();
			reservation.setReservationNum(1);
			Reservation reservation1 = dao.selectReservationNum(reservation);
			System.out.println(reservation1.getPersonnel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*@Test
	public void insertClient() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			
			Reservation reservation = new Reservation();
			
			reservation.setPersonnel(2);
			
			
			dao.insertReservation(reservation);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
	
/*	@Test
	public void updateClient() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			
			Reservation reservation = new Reservation();
			reservation.setReservationNum(1);
			reservation.setCheckIn(new Date());
			reservation.setOptionPrice(1123);
			dao.updateReservation(reservation);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
/*
	@Test
	public void deleteReservation() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ReservationDao dao = session.getMapper(ReservationDao.class);
			
			Reservation client = new Reservation();
			client.setReservationNum(1);
			
			dao.deleteReservation(client);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
