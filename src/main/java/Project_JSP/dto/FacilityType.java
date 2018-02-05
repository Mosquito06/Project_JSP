package Project_JSP.dto;

public class FacilityType {
	private int facilityTypeNum;
	private String facilityTypeName;

	public FacilityType() {
		super();

	}

	public int getFacilityTypeNum() {
		return facilityTypeNum;
	}

	public void setFacilityTypeNum(int facilityTypeNum) {
		this.facilityTypeNum = facilityTypeNum;
	}

	public String getFacilityTypeName() {
		return facilityTypeName;
	}

	public void setFacilityTypeName(String facilityTypeName) {
		this.facilityTypeName = facilityTypeName;
	}

	@Override
	public String toString() {
		return "FacilityType [facilityTypeNum=" + facilityTypeNum + ", facilityTypeName=" + facilityTypeName + "]";
	}

}
