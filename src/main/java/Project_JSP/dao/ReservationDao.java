package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Reservation;
import Project_JSP.dto.ReservationState;



public interface ReservationDao {
	public List<Reservation> selectReservation();
	public Reservation selectReservationNum(Reservation reservation);
	public void insertReservation(Reservation reservation);
	public void updateReservation(Reservation reservation);
	public void updateReservationCancel(Reservation reservation);
	public void deleteReservation(Reservation reservation);
	public List<Reservation> selectReservationDate(Reservation reservation);
	public List<Reservation> selectReservationUser(int clientNum);
	public List<Reservation> selectReservationState(ReservationState state);
	public List<Reservation> selectLastReservation();
	public List<Reservation> selectReservationJoinRoomAndRoomInfo(int clientNum);
	public List<Reservation> selectReservationOnlyReserv(int clientNum);
	public List<Reservation> selectReservationDateByClientNum(Reservation reservation);
}
