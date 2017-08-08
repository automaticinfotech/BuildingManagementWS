package com.aits.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.dao.ProjectAvailabilityDao;
import com.aits.dao.ProjectMasterDao;
import com.aits.dto.ProjectMasterDto;
import com.aits.model.ProjectAvailability;
import com.aits.model.ProjectMaster;
import com.aits.service.ProjectMasterService;

@Service("ProjectMasterService")
public class ProjectMasterServiceImplementation implements ProjectMasterService {
	@Autowired
	private ProjectMasterDao projectMasterDao;

	@Autowired
	ProjectAvailabilityDao projectAvailabilityDao;

	public void setProjectMasterDao(ProjectMasterDao projectMasterDao) {
		this.projectMasterDao = projectMasterDao;
	}

	public void setProjectAvailabilityDao(ProjectAvailabilityDao projectAvailabilityDao) {
		this.projectAvailabilityDao = projectAvailabilityDao;
	}

	@Override
	public boolean getProjectMasterListService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		boolean status = projectMasterDao.getProjectMasterDaoList(projectMaster);

		projectMasterDto.setProjectMasterList(projectMaster.getProjectMasterList());
		return status;
	}

	@Override
	public boolean isProjectExist(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectName(projectMasterDto.getProjectName());
		System.out.println("Inside service" + projectMaster.getProjectName());
		boolean status = projectMasterDao.isProjectExistDao(projectMaster);
		return status;
	}

	@Override
	public boolean insertProjectMasterDetailsService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectName(projectMasterDto.getProjectName());
		projectMaster.setProjectIsActive(projectMasterDto.getProjectIsActive());
		boolean status = projectMasterDao.insertProjectMasterDetailsDao(projectMaster);

		return status;

	}

	@Override
	public boolean findProjectMasterDetailsByIdService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectId(projectMasterDto.getProjectId());
		boolean status = projectMasterDao.findProjectMasterDetailsById(projectMaster);

		projectMasterDto.setProjectName(projectMaster.getProjectName());
		projectMasterDto.setProjectIsActive(projectMaster.getProjectIsActive());
		return status;
	}

	@Override
	public boolean editProjectMasterByIdService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectId(projectMasterDto.getProjectId());
		projectMaster.setProjectName(projectMasterDto.getProjectName());
		projectMaster.setProjectIsActive(projectMasterDto.getProjectIsActive());

		boolean status = projectMasterDao.editProjectMasterById(projectMaster);
		return status;

	}
	/*
	 * @Override public boolean
	 * inactivateProjectMasterDetailsByIdService(ProjectMasterDto
	 * projectMasterDto) { ProjectMaster projectMaster = new ProjectMaster();
	 * projectMaster.setProjectId(projectMasterDto.getProjectId());
	 * projectMaster.setProjectName(projectMasterDto.getProjectName());
	 * projectMaster.setProjectIsActive("I"); boolean status =
	 * projectMasterDao.inactivateProjectMasterDetailsById(projectMaster);
	 * return status; }
	 */

	@Override
	public boolean getActiveProjectMasterListService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		boolean status = projectMasterDao.getActiveProjectMasterDaoList(projectMaster);

		projectMasterDto.setProjectMasterList(projectMaster.getProjectMasterList());
		return status;
	}

	@Override
	public boolean deleteProjectMasterByIdService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectId(projectMasterDto.getProjectId());

		boolean status = projectMasterDao.deleteProjectMasterById(projectMaster);
		return status;
	}

	@Override
	public boolean isProjectExistForUpdateService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectId(projectMasterDto.getProjectId());
		projectMaster.setProjectName(projectMasterDto.getProjectName());
		System.out.println("Inside service" + projectMaster.getProjectName());
		boolean status = projectMasterDao.isProjectExistDaoForUpdate(projectMaster);
		return status;
	}

	@Override
	public boolean deleteProjectAvailabilityDetailsByParentIdService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectId(projectMasterDto.getProjectId());

		ProjectAvailability projectAvailability = new ProjectAvailability();
		projectAvailability.setProjectMaster(projectMaster);

		boolean status = projectAvailabilityDao.deleteProjectAvailabilityDetailsByParentId(projectAvailability);
         if(status){
        	boolean deleteStatus = projectMasterDao.deleteProjectMasterById(projectMaster);
        	return deleteStatus;
         }
		return false;
	}

	@Override
	public boolean getProjectAvailabilityListByprojectIdService(ProjectMasterDto projectMasterDto) {
		int count = 0;
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectId(projectMasterDto.getProjectId());
		ProjectAvailability projectAvailability = new ProjectAvailability();

		projectAvailability.setProjectMaster(projectMaster);

		boolean status = projectAvailabilityDao.getProjectAvailabilityListByprojectIdService(projectAvailability);

		projectMasterDto.setProjectAvailabilityList(projectAvailability.getProjectAvailabilityList());

		List<ProjectAvailability> projectAvailabilityList = projectAvailability.getProjectAvailabilityList();

		for (@SuppressWarnings("unused")
		ProjectAvailability projectAvailability2 : projectAvailabilityList) {
			count++;
		}
		projectMasterDto.setNumberOfAvailabilityRecords(count);

		return status;

	}

}
