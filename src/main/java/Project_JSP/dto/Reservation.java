package Project_JSP.dto;

import java.util.Date;

public class Reservation {
	private int reservationNum;
	private Room roomNum;
	private int totalPrice;
	private Date checkIn;
	private Date checkOut;
	private String personnel;
	private ReservationState state;
	private Client clientNum;
	private String option;
	private Date payDate;
	private String clientReq;

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public int getReservationNum() {
		return reservationNum;
	}

	public void setReservationNum(int reservationNum) {
		this.reservationNum = reservationNum;
	}

	public Room getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(Room roomNum) {
		this.roomNum = roomNum;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	public ReservationState getState() {
		return state;
	}

	public void setState(ReservationState state) {
		this.state = state;
	}

	public Client getClientNum() {
		return clientNum;
	}

	public void setClientNum(Client clientNum) {
		this.clientNum = clientNum;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getClientReq() {
		return clientReq;
	}

	public void setClientReq(String clientReq) {
		this.clientReq = clientReq;
	}

	@Override
	public String toString() {
		return "Reservation [reservationNum=" + reservationNum + ", roomNum=" + roomNum + ", totalPrice=" + totalPrice
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", personnel=" + personnel + ", state=" + state
				+ ", clientNum=" + clientNum + ", option=" + option + ", payDate=" + payDate + ", clientReq="
				+ clientReq + "]";
	}

}
