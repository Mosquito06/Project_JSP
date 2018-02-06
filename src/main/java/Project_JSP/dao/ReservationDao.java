package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Reservation;

public interface ReservationDao {
	public List<Reservation> selectReservation();
	public Reservation selectReservationNum(Reservation reservation);
}
