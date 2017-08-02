package com.aits.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.dao.ProjectMasterDao;
import com.aits.dto.ProjectMasterDto;
import com.aits.model.ProjectMaster;
import com.aits.service.ProjectMasterService;

@Service("ProjectMasterService")
public class ProjectMasterServiceImplementation implements ProjectMasterService {
	@Autowired
	private ProjectMasterDao projectMasterDao;

	public void setProjectMasterDao(ProjectMasterDao projectMasterDao) {
		this.projectMasterDao = projectMasterDao;
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

	@Override
	public boolean inactivateProjectMasterDetailsByIdService(ProjectMasterDto projectMasterDto) {
		ProjectMaster projectMaster = new ProjectMaster();
		projectMaster.setProjectId(projectMasterDto.getProjectId());
		projectMaster.setProjectName(projectMasterDto.getProjectName());
		projectMaster.setProjectIsActive("I");
		boolean status = projectMasterDao.inactivateProjectMasterDetailsById(projectMaster);
		return status;
	}

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

}
