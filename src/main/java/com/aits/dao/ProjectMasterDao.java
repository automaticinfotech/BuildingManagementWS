package com.aits.dao;

import com.aits.model.ProjectMaster;

public interface ProjectMasterDao {
	
	public boolean getProjectMasterDaoList(ProjectMaster projectMaster);

	public boolean isProjectExistDao(ProjectMaster projectMaster);

	public boolean insertProjectMasterDetailsDao(ProjectMaster projectMaster);

	public boolean editProjectMasterById(ProjectMaster projectMaster);

	public boolean inactivateProjectMasterDetailsById(ProjectMaster projectMaster);

	public boolean findProjectMasterDetailsById(ProjectMaster projectMaster);

	public boolean getActiveProjectMasterDaoList(ProjectMaster projectMaster);

	public boolean deleteProjectMasterById(ProjectMaster projectMaster);
	
	public boolean isProjectExistDaoForUpdate(ProjectMaster projectMaster);

}
