package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.ActivityContent;

public interface ActivityContentDao {
	public List<ActivityContent> selectAll();
	public ActivityContent selectByNum(ActivityContent activityNum);
	public int insert(ActivityContent activityContent);
	public int update(ActivityContent activityContent);
	public int delete(ActivityContent activityContent);
	public int selectLastInsert();
}
