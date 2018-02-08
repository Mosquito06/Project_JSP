package Project_JSP.dto;

import java.util.Date;

public class Event {
	private int eventNum;
	private String eventTitle;
	private String eventIntroduce;
	private Date eventStartDay;
	private Date eventEndDay;
	private String eventImgPath;

	public Event() {}

	public int getEventNum() {
		return eventNum;
	}

	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}
	

	

	public String getEventImgPath() {
		return eventImgPath;
	}

	public void setEventImgPath(String eventImgPath) {
		this.eventImgPath = eventImgPath;
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

	public String getEventIntroduce() {
		return eventIntroduce;
	}

	public void setEventIntroduce(String eventIntroduce) {
		this.eventIntroduce = eventIntroduce;
	}

	public void setEventEndDay(Date eventEndDay) {
		this.eventEndDay = eventEndDay;
	}



	@Override
	public String toString() {
		return "Event [eventNum=" + eventNum + ", eventTitle=" + eventTitle + ", eventIntroduce=" + eventIntroduce
				+ ", eventStartDay=" + eventStartDay + ", eventEndDay=" + eventEndDay + ", eventImgPath=" + eventImgPath
				+ "]";
	}
}
