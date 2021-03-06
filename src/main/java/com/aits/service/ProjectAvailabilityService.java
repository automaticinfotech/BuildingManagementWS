package com.aits.service;

import com.aits.dto.ProjectAvailabilityDto;

public interface ProjectAvailabilityService {
	boolean getProjectAvailabilityListService(ProjectAvailabilityDto projectAvailabilityDto);

	boolean insertProjectAvailabilityDetailsService(ProjectAvailabilityDto projectAvailabilityDto);

	boolean editProjectAvailabilityByIdService(ProjectAvailabilityDto projectAvailabilityDto);

	boolean findProjectAvailabilityDetailsByIdService(ProjectAvailabilityDto projectAvailabilityDto);

	boolean deleteProjectAvailabilityDetailsByIdService(ProjectAvailabilityDto projectAvailabilityDto);

	boolean getProjectAvailabilityListByIdService(ProjectAvailabilityDto projectAvailabilityDto);

	boolean isProjectAvailabilityExist(ProjectAvailabilityDto projectAvailabilityDto);

	boolean getProjectAvailabilityByAvailabilityId(ProjectAvailabilityDto projectAvailabilityDto);

}
