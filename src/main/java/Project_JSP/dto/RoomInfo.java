package Project_JSP.dto;

public class RoomInfo {
	private int roomInfoNum;
	private String roomInfoName;
	private RoomGrade roomGrade;
	private ViewType viewType;
	private BedType bedType;
	private String roomImg;

	public RoomInfo() {
		super();

	}

	public int getRoomInfoNum() {
		return roomInfoNum;
	}

	public void setRoomInfoNum(int roomInfoNum) {
		this.roomInfoNum = roomInfoNum;
	}

	public String getRoomInfoName() {
		return roomInfoName;
	}

	public void setRoomInfoName(String roomInfoName) {
		this.roomInfoName = roomInfoName;
	}

	public RoomGrade getRoomGrade() {
		return roomGrade;
	}

	public void setRoomGrade(RoomGrade roomGrade) {
		this.roomGrade = roomGrade;
	}

	public ViewType getViewType() {
		return viewType;
	}

	public void setViewType(ViewType viewType) {
		this.viewType = viewType;
	}

	public BedType getBedType() {
		return bedType;
	}

	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

	public String getRoomImg() {
		return roomImg;
	}

	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}

	@Override
	public String toString() {
		return "RoomInfo [roomInfoNum=" + roomInfoNum + ", roomInfoName=" + roomInfoName + ", roomGrade=" + roomGrade
				+ ", viewType=" + viewType + ", bedType=" + bedType + ", roomImg=" + roomImg + "]";
	}

}
