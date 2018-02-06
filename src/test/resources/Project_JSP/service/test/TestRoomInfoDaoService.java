package Project_JSP.service.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import Project_JSP.dao.EventDao;
import Project_JSP.dao.RoomInfoDao;
import Project_JSP.dto.BedType;
import Project_JSP.dto.Event;
import Project_JSP.dto.RoomGrade;
import Project_JSP.dto.RoomInfo;
import Project_JSP.dto.ViewType;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class TestRoomInfoDaoService {

	/*@Test
	public void selectEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			List<RoomInfo> list  =dao.selectRoomInfo();
			
			for(RoomInfo r : list){
				System.out.println(r.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectEventByNum() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			
			RoomInfo roomInfo = new RoomInfo();
			roomInfo.setRoomInfoNum(1);
			
			RoomInfo selectRoomInfo = dao.selectRoomInfoByNum(roomInfo);
			System.out.println(selectRoomInfo.toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void insertEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			
			RoomInfo roomInfo = new RoomInfo();
			roomInfo.setRoomInfoNum(1);
			roomInfo.setBedType(BedType.SINGLE);
			roomInfo.setRoomGrade(RoomGrade.STANDARD);
			roomInfo.setRoomImg("방 경로");
			roomInfo.setRoomInfoName("스탠다드");
			roomInfo.setViewType(ViewType.OCEAN);
								
			dao.insertRoomInfo(roomInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	/*@Test
	public void updateEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			
			RoomInfo roomInfo = new RoomInfo();
			roomInfo.setRoomInfoNum(1);
			roomInfo.setBedType(BedType.DOUBLE);
			roomInfo.setRoomGrade(RoomGrade.PREMIER);
			roomInfo.setRoomImg("이미지 경로 수정");
			roomInfo.setRoomInfoName("프리미어");
			roomInfo.setViewType(ViewType.GARDEN);
								
			dao.updateRoomInfo(roomInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	@Test
	public void deleteEvent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			RoomInfoDao dao = session.getMapper(RoomInfoDao.class);
			
			RoomInfo roomInfo = new RoomInfo();
			roomInfo.setRoomInfoNum(1);
								
			dao.deleteRoomInfo(roomInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
