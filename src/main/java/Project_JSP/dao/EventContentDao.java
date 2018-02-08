package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.EventContent;

public interface EventContentDao {
	public List<EventContent> selectEventContent();
	public EventContent selectEventContentByNum(EventContent eventContent);
	public int insertEventContent(EventContent eventContent);
	public void updateEventContent(EventContent eventContent);
	public void deleteEventContent(EventContent eventContent);
}
