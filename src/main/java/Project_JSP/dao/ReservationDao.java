package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Reservation;

public interface ReservationDao {
	public List<Reservation> selectReservation();
	public Reservation selectReservationNum(Reservation reservation);
	public void insertReservation(Reservation reservation);
	public void updateReservation(Reservation reservation);
	public void deleteReservation(Reservation reservation);
}
