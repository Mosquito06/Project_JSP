package Project_JSP.dto;

public class EventContent {
	private Event evnetNum;
	private String eventContentImg;

	public EventContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event getEvnetNum() {
		return evnetNum;
	}

	public void setEvnetNum(Event evnetNum) {
		this.evnetNum = evnetNum;
	}

	public String getEventContentImg() {
		return eventContentImg;
	}

	public void setEventContentImg(String eventContentImg) {
		this.eventContentImg = eventContentImg;
	}

	@Override
	public String toString() {
		return "EventContent [evnetNum=" + evnetNum + ", eventContentImg=" + eventContentImg + "]";
	}

}
