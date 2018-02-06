package Project_JSP.dto;

public class Facility {
	private int facilityNum;
	private String facilityName;
	private String facilityTel;
	private String facilityTime;
	private String facilityLocation;
	private int facilitySeat;
	private FacilityType facilityType;

	public Facility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFacilityNum() {
		return facilityNum;
	}

	public void setFacilityNum(int facilityNum) {
		this.facilityNum = facilityNum;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityTel() {
		return facilityTel;
	}

	public void setFacilityTel(String facilityTel) {
		this.facilityTel = facilityTel;
	}

	public String getFacilityTime() {
		return facilityTime;
	}

	public void setFacilityTime(String facilityTime) {
		this.facilityTime = facilityTime;
	}

	public String getFacilityLocation() {
		return facilityLocation;
	}

	public void setFacilityLocation(String facilityLocation) {
		this.facilityLocation = facilityLocation;
	}

	public int getFacilitySeat() {
		return facilitySeat;
	}

	public void setFacilitySeat(int facilitySeat) {
		this.facilitySeat = facilitySeat;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	@Override
	public String toString() {
		return "Facility [facilityNum=" + facilityNum + ", facilityName=" + facilityName + ", facilityTel="
				+ facilityTel + ", facilityTime=" + facilityTime + ", facilityLocation=" + facilityLocation
				+ ", facilitySeat=" + facilitySeat + ", facilityType=" + facilityType + "]";
	}

}
