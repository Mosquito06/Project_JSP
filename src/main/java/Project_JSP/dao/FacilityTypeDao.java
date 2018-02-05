package Project_JSP.dao;

import java.util.List;

import Project_JSP.dto.FacilityType;

public interface FacilityTypeDao {
	public List<FacilityType> selectFacilityType();
	public FacilityType selectFacilityTypeByNum(FacilityType facilityType);
	public void insertFacilityType(FacilityType facilityType);
	public void updateFacilityType(FacilityType facilityType);
	public void deleteFacilityType(FacilityType facilityType);
	
}
