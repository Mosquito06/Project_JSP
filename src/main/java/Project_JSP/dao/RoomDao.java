package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Room;

public interface RoomDao {
	public List<Room> selectRoom();
	public Room selectRoomByNum(Room room);
	public void insertRoom(Room room);
	public void updateRoom(Room room);
	public void deleteRoom(Room room);
	public List<Room> selectAvailabilityRoom();
}
