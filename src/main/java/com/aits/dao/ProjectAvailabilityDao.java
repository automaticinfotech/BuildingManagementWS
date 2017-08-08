package com.aits.dao;

import com.aits.dto.ProjectAvailabilityDto;
import com.aits.model.ProjectAvailability;

public interface ProjectAvailabilityDao {
	boolean getProjectAvailabilityDaoList(ProjectAvailability projectAvailability);

	boolean insertProjectAvailabilityDetailsDao(ProjectAvailability projectAvailability);

	boolean editProjectAvaialabilityById(ProjectAvailability projectAvailability);

	boolean findProjectMasterDetailsById(ProjectAvailability projectAvailability);

	boolean deleteProjectMasterDetailsById(ProjectAvailability projectAvailability);

	boolean getProjectAvailabilityByIdDaoList(ProjectAvailability projectAvailability);

	boolean isProjectAvailabilityExist(ProjectAvailability projectAvailability, ProjectAvailabilityDto projectAvailabilityDto);

	boolean getProjectAvailabilityByAvailabilityId(ProjectAvailabilityDto projectAvailabilityDto);

	boolean deleteProjectAvailabilityDetailsByParentId(ProjectAvailability projectAvailability);

	boolean getProjectAvailabilityListByprojectIdService(ProjectAvailability projectAvailability);
}
