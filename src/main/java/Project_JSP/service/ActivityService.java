package Project_JSP.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import Project_JSP.dao.ActivityContentDao;
import Project_JSP.dao.ActivityDao;
import Project_JSP.dto.Activity;
import Project_JSP.dto.ActivityContent;
import Project_JSP.mvc.util.MySqlSessionFactory;

public class ActivityService {
	private static final ActivityService INSTANCE = new ActivityService();
	private static final String log = "[ActivityService]";

	public static ActivityService getInstance() {
		return INSTANCE;
	}

	private ActivityService() {
	}

	public List<Activity> selectList() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ActivityDao dao = session.getMapper(ActivityDao.class);

			return dao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Map<String,List> selectListContent() {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ActivityDao dao = session.getMapper(ActivityDao.class);
			ActivityContentDao contentDao = session.getMapper(ActivityContentDao.class);
			
			HashMap<String,List> map = new HashMap<>();
			
			map.put("activity", dao.selectAll());
			map.put("content", contentDao.selectAll());
			
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Activity selectByNum(Activity activity) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ActivityDao dao = session.getMapper(ActivityDao.class);

			return dao.selectByNum(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Map<String,Object> selectContentByNum(Activity activity) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ActivityDao dao = session.getMapper(ActivityDao.class);
			ActivityContentDao contentDao = session.getMapper(ActivityContentDao.class);
			
			HashMap<String,Object> map = new HashMap<>();
			
			map.put("activity", dao.selectByNum(activity));
			map.put("content", contentDao.selectByNum(new ActivityContent(activity.getNum())));
			
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return null;
	}
	
	public Activity selectByType(Activity activity) {
		try (SqlSession session = MySqlSessionFactory.openSession()) {
			ActivityDao dao = session.getMapper(ActivityDao.class);
			System.out.println(dao.selectByType(activity));
			return dao.selectByType(activity);
		} catch (Exception e) { 
			e.printStackTrace();
		}

		return null;
	}
	
	public int selectLastNum(){
		try(SqlSession session = MySqlSessionFactory.openSession()){
			ActivityDao dao = session.getMapper(ActivityDao.class);
			
			return dao.selectLastInsert();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;		
	}
	
	public int insert(Activity activity, ActivityContent content) {
		SqlSession session = MySqlSessionFactory.openSession();

		int newEventId = selectLastNum();
		
		try {	
			
			ActivityDao dao = session.getMapper(ActivityDao.class);
			ActivityContentDao contentDao = session.getMapper(ActivityContentDao.class);
			
			
			newEventId++; 
			activity.setNum(newEventId);
			int result = dao.insert(activity);
			System.out.println("insertactivity");
			System.out.println(newEventId);

			if (result < 0) {
				System.out.println(log + "insert event fail");
				return -2;
			}
			
			content.setNum(newEventId);
			int successContent = contentDao.insert(content);
			System.out.println(successContent);

			if (successContent < 0) {
				System.out.println(log + "insert eventContent fail");
				return -3;
			}

			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return 1;
	}

	public int update(Activity activity, ActivityContent content) {
		int result = -1;
		SqlSession session = MySqlSessionFactory.openSession();
		try {
			ActivityDao dao = session.getMapper(ActivityDao.class);
			ActivityContentDao contentDao = session.getMapper(ActivityContentDao.class);

			result = dao.update(activity);
			if (result < 0) {
				System.out.println(log + "update activity fail");
				return -1;
			}
			
			result = contentDao.update(content);
			
			if (result < 0) {
				System.out.println(log + "update activityContent fail");
				return -2;
			}

			session.commit(); 
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}

		return result;

	}

	public int delete(Activity activity) {
		int result = -1;
		SqlSession session = MySqlSessionFactory.openSession();
		try {
			ActivityDao dao = session.getMapper(ActivityDao.class);
			ActivityContentDao contentDao = session.getMapper(ActivityContentDao.class);
			
			result = contentDao.delete(new ActivityContent(activity.getNum()));
			
			if(result < 0){
				System.out.println(log + "delete eventContent fail");
				return result;
			}
			
			result = dao.delete(activity);
			
			if(result < 0){
				System.out.println(log + "delete eventContent fail");
				return result;
			}
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}

}
