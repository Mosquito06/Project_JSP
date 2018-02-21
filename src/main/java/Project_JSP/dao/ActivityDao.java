package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Activity;

public interface ActivityDao {
	public List<Activity> selectAll();
	public Activity selectByNum(Activity activity);
	public Activity selectByType(Activity activity);
	public int insert(Activity activity);
	public int update(Activity activity);
	public int delete(Activity activity);
	public int selectLastInsert();
}
