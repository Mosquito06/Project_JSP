package Project_JSP.dto;

public class EventContent {
	private Event eventNum;
	private String eventContentImg;

	public EventContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event getEventNum() {
		return eventNum;
	}

	public void setEventNum(Event eventNum) {
		this.eventNum = eventNum;
	}

	public String getEventContentImg() {
		return eventContentImg;
	}

	public void setEventContentImg(String eventContentImg) {
		this.eventContentImg = eventContentImg;
	}

	@Override
	public String toString() {
		return "EventContent [eventNum=" + eventNum + ", eventContentImg=" + eventContentImg + "]";
	}

}
