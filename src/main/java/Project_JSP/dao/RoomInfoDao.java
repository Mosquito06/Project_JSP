package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.RoomInfo;

public interface RoomInfoDao {
	public List<RoomInfo> selectRoomInfo();
	public RoomInfo selectRoomInfoByNum(RoomInfo roomInfo);
	public void insertRoomInfo(RoomInfo roomInfo);
	public void updateRoomInfo(RoomInfo roomInfo);
	public void deleteRoomInfo(RoomInfo roomInfo);
}
