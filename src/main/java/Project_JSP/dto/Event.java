package Project_JSP.dto;

import java.util.Date;

public class Event {
	private int eventNum;
	private String eventName;
	private String eventTitle;
	private Date eventStartDay;
	private Date eventEndDay;
	private String eventImg;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEventNum() {
		return eventNum;
	}

	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public Date getEventStartDay() {
		return eventStartDay;
	}

	public void setEventStartDay(Date eventStartDay) {
		this.eventStartDay = eventStartDay;
	}

	public Date getEventEndDay() {
		return eventEndDay;
	}

	public void setEventEndDay(Date eventEndDay) {
		this.eventEndDay = eventEndDay;
	}

	public String getEventImg() {
		return eventImg;
	}

	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}

	@Override
	public String toString() {
		return "Event [eventNum=" + eventNum + ", eventName=" + eventName + ", eventTitle=" + eventTitle
				+ ", eventStartDay=" + eventStartDay + ", eventEndDay=" + eventEndDay + ", eventImg=" + eventImg + "]";
	}

}
