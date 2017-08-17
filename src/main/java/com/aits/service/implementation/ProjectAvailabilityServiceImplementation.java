package com.aits.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.dao.ProjectAvailabilityDao;
import com.aits.dto.ProjectAvailabilityDto;
import com.aits.model.ProjectAvailability;
import com.aits.service.ProjectAvailabilityService;

@Service("ProjectAvailabilityService")
public class ProjectAvailabilityServiceImplementation implements ProjectAvailabilityService{

	@Autowired
	private ProjectAvailabilityDao projectAvailabilityDao;
	
	public void setProjectAvailabilityDao(ProjectAvailabilityDao projectAvailabilityDao) {
		this.projectAvailabilityDao = projectAvailabilityDao;
	}

	@Override
	public boolean getProjectAvailabilityListService(ProjectAvailabilityDto projectAvailabilityDto) {
		ProjectAvailability projectAvailability=new ProjectAvailability();
		boolean status=projectAvailabilityDao.getProjectAvailabilityDaoList(projectAvailability);
		
		projectAvailabilityDto.setProjectAvailabilityList(projectAvailability.getProjectAvailabilityList());
		return status;
	}

	@Override
	public boolean insertProjectAvailabilityDetailsService(ProjectAvailabilityDto projectAvailabilityDto) {
		ProjectAvailability projectAvailability=new ProjectAvailability();
		projectAvailability.setAreaSquareFoot(projectAvailabilityDto.getAreaSquareFoot());
		projectAvailability.setFloorNumber(projectAvailabilityDto.getFloorNumber());
		projectAvailability.setOfficeNumber(projectAvailabilityDto.getOfficeNumber());
		projectAvailability.setIsActive(projectAvailabilityDto.getIsActive());
		projectAvailability.setWingName(projectAvailabilityDto.getWingName());
		projectAvailability.setProjectMaster(projectAvailabilityDto.getProjectMaster());
		projectAvailability.setDescription(projectAvailabilityDto.getDescription());
		
		boolean status=projectAvailabilityDao.insertProjectAvailabilityDetailsDao(projectAvailability);
		return status;
	}

	@Override
	public boolean editProjectAvailabilityByIdService(ProjectAvailabilityDto projectAvailabilityDto) {
		ProjectAvailability projectAvailability=new ProjectAvailability();
		
		projectAvailability.setAreaSquareFoot(projectAvailabilityDto.getAreaSquareFoot());
		projectAvailability.setFloorNumber(projectAvailabilityDto.getFloorNumber());
		projectAvailability.setOfficeNumber(projectAvailabilityDto.getOfficeNumber());
		projectAvailability.setAvailabilityId(projectAvailabilityDto.getAvailabilityId());
		projectAvailability.setIsActive(projectAvailabilityDto.getIsActive());
		projectAvailability.setWingName(projectAvailabilityDto.getWingName());
		projectAvailability.setProjectMaster(projectAvailabilityDto.getProjectMaster());
		projectAvailability.setDescription(projectAvailabilityDto.getDescription());
		
		boolean status=projectAvailabilityDao.editProjectAvaialabilityById(projectAvailability);
		return status;
	}

	@Override
	public boolean findProjectAvailabilityDetailsByIdService(ProjectAvailabilityDto projectAvailabilityDto) {
		ProjectAvailability projectAvailability=new ProjectAvailability();
		projectAvailability.setAvailabilityId(projectAvailabilityDto.getAvailabilityId());
		
		boolean status=projectAvailabilityDao.findProjectMasterDetailsById(projectAvailability);
		return status;
	}

	@Override
	public boolean deleteProjectAvailabilityDetailsByIdService(ProjectAvailabilityDto projectAvailabilityDto) {
		ProjectAvailability projectAvailability=new ProjectAvailability();
		
		projectAvailability.setAreaSquareFoot(projectAvailabilityDto.getAreaSquareFoot());
		projectAvailability.setFloorNumber(projectAvailabilityDto.getFloorNumber());
		projectAvailability.setOfficeNumber(projectAvailabilityDto.getOfficeNumber());
		projectAvailability.setAvailabilityId(projectAvailabilityDto.getAvailabilityId());
		projectAvailability.setIsActive("I");
		projectAvailability.setWingName(projectAvailabilityDto.getWingName());
		projectAvailability.setProjectMaster(projectAvailabilityDto.getProjectMaster());
		
		boolean status=projectAvailabilityDao.deleteProjectMasterDetailsById(projectAvailability);
		return status;
	}

	@Override
	public boolean getProjectAvailabilityListByIdService(ProjectAvailabilityDto projectAvailabilityDto) {
		ProjectAvailability projectAvailability=new ProjectAvailability();
		projectAvailability.setProjectMaster(projectAvailabilityDto.getProjectMaster());
		boolean status=projectAvailabilityDao.getProjectAvailabilityByIdDaoList(projectAvailability);
		
		projectAvailabilityDto.setProjectAvailabilityList(projectAvailability.getProjectAvailabilityList());
		return status;
	}

	@Override
	public boolean isProjectAvailabilityExist(ProjectAvailabilityDto projectAvailabilityDto) {
		ProjectAvailability projectAvailability=new ProjectAvailability();
		
		projectAvailability.setAreaSquareFoot(projectAvailabilityDto.getAreaSquareFoot());
		projectAvailability.setFloorNumber(projectAvailabilityDto.getFloorNumber());
		projectAvailability.setOfficeNumber(projectAvailabilityDto.getOfficeNumber());
		projectAvailability.setIsActive(projectAvailabilityDto.getIsActive());
		projectAvailability.setWingName(projectAvailabilityDto.getWingName());
		projectAvailability.setProjectMaster(projectAvailabilityDto.getProjectMaster());
		
		boolean status=projectAvailabilityDao.isProjectAvailabilityExist(projectAvailability,projectAvailabilityDto);
		return status;
	}

	@Override
	public boolean getProjectAvailabilityByAvailabilityId(ProjectAvailabilityDto projectAvailabilityDto) {
		ProjectAvailability projectAvailability=new ProjectAvailability();
		projectAvailability.setAvailabilityId(projectAvailabilityDto.getAvailabilityId());
		boolean status=projectAvailabilityDao.getProjectAvailabilityByAvailabilityId(projectAvailabilityDto);
		return status;
	}

}
