package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.Event;

public interface EventDao {
	public List<Event> selectEvent();
	public Event selectEventByNum(Event event);
	public void insertEvent(Event event);
	public void updateEvent(Event event);
	public void deleteEvent(Event event);
	
}
