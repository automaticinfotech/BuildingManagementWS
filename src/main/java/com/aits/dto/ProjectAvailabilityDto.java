package com.aits.dto;

import java.util.List;

import com.aits.model.ProjectAvailability;
import com.aits.model.ProjectMaster;

public class ProjectAvailabilityDto {
	private int availabilityId;
	private String wingName;
	private long floorNumber;
	private String OfficeNumber;
	private double areaSquareFoot;
	private String isActive;
	private String description;
	private ProjectMaster projectMaster;
	private List<ProjectAvailability> projectAvailabilityList;

	public int getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}

	public String getWingName() {
		return wingName;
	}

	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	public long getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(long floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getOfficeNumber() {
		return OfficeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		OfficeNumber = officeNumber;
	}

	public double getAreaSquareFoot() {
		return areaSquareFoot;
	}

	public void setAreaSquareFoot(double areaSquareFoot) {
		this.areaSquareFoot = areaSquareFoot;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectMaster getProjectMaster() {
		return projectMaster;
	}

	public void setProjectMaster(ProjectMaster projectMaster) {
		this.projectMaster = projectMaster;
	}

	public List<ProjectAvailability> getProjectAvailabilityList() {
		return projectAvailabilityList;
	}

	public void setProjectAvailabilityList(List<ProjectAvailability> projectAvailabilityList) {
		this.projectAvailabilityList = projectAvailabilityList;
	}

}
