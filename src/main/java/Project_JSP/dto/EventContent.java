package Project_JSP.dto;

public class EventContent {
	private int eventNum;
	private String eventContent;

	public EventContent() {}
	
	public EventContent(int eventNum) {
		this.eventNum = eventNum;
	}

	public EventContent(int eventNum, String eventContent) {
		this.eventNum = eventNum;
		this.eventContent = eventContent;
	}

	public int getEventNum() {
		return eventNum;
	}

	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	@Override
	public String toString() {
		return "EventContent [eventNum=" + eventNum + ", eventContent=" + eventContent + "]";
	}

}
