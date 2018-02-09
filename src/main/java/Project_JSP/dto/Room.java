package Project_JSP.dto;

public class Room {
	private int roomNum;
	private RoomInfo roomInfoNum;
	private int roomPrice;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public RoomInfo getRoomInfoNum() {
		return roomInfoNum;
	}

	public void setRoomInfoNum(RoomInfo roomInfoNum) {
		this.roomInfoNum = roomInfoNum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", roomInfoNum=" + roomInfoNum + ", roomPrice=" + roomPrice + "]";
	}

}
