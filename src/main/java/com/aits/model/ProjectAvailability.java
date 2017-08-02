package com.aits.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_Availability")
public class ProjectAvailability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Availability_Id")
	private int availabilityId;

	@Column(name = "Wing_Name", length = 50)
	private String wingName;

	@Column(name = "Floor_Number", length = 8)
	private long floorNumber;

	@Column(name = "Office_Number", length = 8)
	private String OfficeNumber;

	@Column(name = "Area_Square_Foot", length = 20)
	private double areaSquareFoot;

	@Column(name = "isActive", length = 1)
	private String isActive;
	
	@ManyToOne(targetEntity = ProjectMaster.class, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE })
	@JoinColumn(name = "Fk_Project_Id")
	private ProjectMaster projectMaster;

	@Transient
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
