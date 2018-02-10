package Project_JSP.dto;

public class RoomInfo {
	private int roomInfoNum;
	private String roomInfoName;
	private RoomGrade roomGrade;
	private String gradeView;
	private ViewType viewType;
	private BedType bedType;
	private String roomSize;
	private String roomImg;
	private String reservationImg;

	public RoomInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoomInfoNum() {
		return roomInfoNum;
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

	public String getGradeView() {
		return gradeView;
	}

	public void setGradeView(String gradeView) {
		this.gradeView = gradeView;
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

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getRoomImg() {
		return roomImg;
	}

	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}

	public String getReservationImg() {
		return reservationImg;
	}

	public void setReservationImg(String reservationImg) {
		this.reservationImg = reservationImg;
	}

	public void setRoomInfoNum(int roomInfoNum) {
		this.roomInfoNum = roomInfoNum;
	}

	@Override
	public String toString() {
		return "RoomInfo [roomInfoNum=" + roomInfoNum + ", roomInfoName=" + roomInfoName + ", roomGrade=" + roomGrade
				+ ", gradeView=" + gradeView + ", viewType=" + viewType + ", bedType=" + bedType + ", roomSize="
				+ roomSize + ", roomImg=" + roomImg + ", reservationImg=" + reservationImg + "]";
	}

}
