package Project_JSP.dto;

public class Dining {
	private int diningNum;
	private String diningName;
	private String diningTel;
	private String diningTime;
	private String diningLocation;
	private String diningSeat;
	private DiningType diningType;

	public Dining() {
		super();
	}

	public int getDiningNum() {
		return diningNum;
	}

	public void setDiningNum(int diningNum) {
		this.diningNum = diningNum;
	}

	public String getDiningName() {
		return diningName;
	}

	public void setDiningName(String diningName) {
		this.diningName = diningName;
	}

	public String getDiningTel() {
		return diningTel;
	}

	public void setDiningTel(String diningTel) {
		this.diningTel = diningTel;
	}

	public String getDiningTime() {
		return diningTime;
	}

	public void setDiningTime(String diningTime) {
		this.diningTime = diningTime;
	}

	public String getDiningLocation() {
		return diningLocation;
	}

	public void setDiningLocation(String diningLocation) {
		this.diningLocation = diningLocation;
	}

	public String getDiningSeat() {
		return diningSeat;
	}

	public void setDiningSeat(String diningSeat) {
		this.diningSeat = diningSeat;
	}

	public DiningType getDiningType() {
		return diningType;
	}

	public void setDiningType(DiningType diningType) {
		this.diningType = diningType;
	}

	@Override
	public String toString() {
		return "Dining [diningNum=" + diningNum + ", diningName=" + diningName + ", diningTel=" + diningTel
				+ ", diningTime=" + diningTime + ", diningLocation=" + diningLocation + ", diningSeat=" + diningSeat
				+ ", diningType=" + diningType + "]";
	}

}
