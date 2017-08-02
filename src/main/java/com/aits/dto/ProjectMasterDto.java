package com.aits.dto;

import java.util.List;

import com.aits.model.ProjectAvailability;
import com.aits.model.ProjectMaster;

public class ProjectMasterDto implements Cloneable {

	private int projectId;

	private String projectName;

	private String projectIsActive;

	private List<ProjectMaster> projectMasterList;

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

	
	
	
}
