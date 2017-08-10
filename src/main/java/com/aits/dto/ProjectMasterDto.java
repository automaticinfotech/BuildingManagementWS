package com.aits.dto;

import java.util.List;

import com.aits.model.ProjectAvailability;
import com.aits.model.ProjectMaster;

public class ProjectMasterDto {

	private int projectId;

	private String projectName;

	private String projectIsActive;

	private int numberOfAvailabilityRecords;

	private List<ProjectMaster> projectMasterList;

	private List<ProjectAvailability> projectAvailabilityList;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIsActive() {
		return projectIsActive;
	}

	public void setProjectIsActive(String projectIsActive) {
		this.projectIsActive = projectIsActive;
	}

	public List<ProjectMaster> getProjectMasterList() {
		return projectMasterList;
	}

	public void setProjectMasterList(List<ProjectMaster> projectMasterList) {
		this.projectMasterList = projectMasterList;
	}

	public List<ProjectAvailability> getProjectAvailabilityList() {
		return projectAvailabilityList;
	}

	public void setProjectAvailabilityList(List<ProjectAvailability> projectAvailabilityList) {
		this.projectAvailabilityList = projectAvailabilityList;
	}

	public int getNumberOfAvailabilityRecords() {
		return numberOfAvailabilityRecords;
	}

	public void setNumberOfAvailabilityRecords(int numberOfAvailabilityRecords) {
		this.numberOfAvailabilityRecords = numberOfAvailabilityRecords;
	}

}
