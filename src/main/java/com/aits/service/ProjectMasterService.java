package com.aits.service;

import com.aits.dto.ProjectMasterDto;

public interface ProjectMasterService {

	public boolean getProjectMasterListService(ProjectMasterDto projectMasterDto);

	public boolean isProjectExist(ProjectMasterDto projectMasterDto);

	public boolean insertProjectMasterDetailsService(ProjectMasterDto projectMasterDto);

	public boolean findProjectMasterDetailsByIdService(ProjectMasterDto projectMasterDto);
	
	public boolean editProjectMasterByIdService(ProjectMasterDto projectMasterDto);

	public boolean getActiveProjectMasterListService(ProjectMasterDto projectMasterDto);

	public boolean deleteProjectMasterByIdService(ProjectMasterDto projectMasterDto);
	
	public boolean isProjectExistForUpdateService(ProjectMasterDto projectMasterDto);

	public boolean deleteProjectAvailabilityDetailsByParentIdService(ProjectMasterDto projectMasterDto);

	public boolean getProjectAvailabilityListByprojectIdService(ProjectMasterDto projectMasterDto);
	
	
}
