package Project_JSP.dto;

import java.util.Date;

public class Reservation {
	private int reservationNum;
	private Room roomNum;
	private int totalPrice;
	private Date checkIn;
	private Date checkOut;
	private int personnel;
	private ReservationState state;
	private Client clientNum;
	private int optionPrice;
	private Date payDate;

	public Reservation(Room roomNum, int total_price, Date checkIn, Date checkOut, int personnel,
			ReservationState state, Client clientNum, int optionPrice, Date payDate) {
		super();
		this.roomNum = roomNum;
		this.totalPrice = total_price;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.personnel = personnel;
		this.state = state;
		this.clientNum = clientNum;
		this.optionPrice = optionPrice;
		this.payDate = payDate;
	}

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

	public int getTotal_price() {
		return totalPrice;
	}

	public void setTotal_price(int totalPrice) {
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

	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
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

	public int getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}
