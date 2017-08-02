package com.aits.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_Project_Master")
public class ProjectMaster implements Cloneable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Project_Id")
	private int projectId;

	@Column(name = "Project_Name", length = 50)
	private String projectName;

	@Column(name = "Project_isActive", length = 1)
	private String projectIsActive;

	@Transient
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
