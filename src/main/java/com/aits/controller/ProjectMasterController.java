package com.aits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aits.dto.ProjectAvailabilityDto;
import com.aits.dto.ProjectMasterDto;
import com.aits.service.ProjectMasterService;

@RestController
public class ProjectMasterController {
	@Autowired
	private ProjectMasterService projectMasterService;

	public void setProjectMasterService(ProjectMasterService projectMasterService) {
		this.projectMasterService = projectMasterService;
	}

	@RequestMapping(value = "/getProjectMasterList", method = RequestMethod.GET)
	public ResponseEntity<?> getProjectMasterList() {
		ProjectMasterDto projectMasterDto = new ProjectMasterDto();

		boolean status = projectMasterService.getProjectMasterListService(projectMasterDto);
		if (status) {
			return new ResponseEntity<>(projectMasterDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/insertProjectMasterDetails", method = RequestMethod.POST)
	public ResponseEntity<?> insertProjectMasterDetails(@RequestBody ProjectMasterDto projectMasterDto) {
		System.out.println("Creating Project : " + projectMasterDto.getProjectName());

		if (projectMasterService.isProjectExist(projectMasterDto)) {
			// System.out.println("A Project with name " +
			// projectMasterDto.getProjectName() + " already exist");
			projectMasterService.getProjectMasterListService(projectMasterDto);
			return new ResponseEntity<>(projectMasterDto, HttpStatus.CONFLICT);// 409
		}

		boolean status = projectMasterService.insertProjectMasterDetailsService(projectMasterDto);
		if (status) {
			projectMasterService.getProjectMasterListService(projectMasterDto);
			return new ResponseEntity<>(projectMasterDto, HttpStatus.CREATED);// 201
		}
		return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);// 400
	}

	@RequestMapping(value = "/findProjectMasterDetailsById", method = RequestMethod.POST)
	public ResponseEntity<?> findProjectMasterDetailsById(@RequestBody ProjectMasterDto projectMasterDto) {

		boolean status = projectMasterService.findProjectMasterDetailsByIdService(projectMasterDto);
		if (status) {
			projectMasterService.getProjectMasterListService(projectMasterDto);
			return new ResponseEntity<>(projectMasterDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/editProjectMasterById", method = RequestMethod.POST)
	public ResponseEntity<?> editProjectMasterById(@RequestBody ProjectMasterDto projectMasterDto) {
		boolean status = false;
		System.out.println("Inside edit Project" + projectMasterDto.getProjectId());
		
		if (projectMasterDto.getProjectId() == 0) {
			projectMasterService.getProjectMasterListService(projectMasterDto);
			return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);// 400
		} else {
			if (projectMasterService.isProjectExistForUpdateService(projectMasterDto)) {
				projectMasterService.getProjectMasterListService(projectMasterDto);
				return new ResponseEntity<>(projectMasterDto, HttpStatus.CONFLICT);// 409
			}else{
				status = projectMasterService.editProjectMasterByIdService(projectMasterDto);
				if (status) {
					ProjectMasterDto projectMasterDto1 = new ProjectMasterDto();
					projectMasterService.getProjectMasterListService(projectMasterDto1);
					return new ResponseEntity<>(projectMasterDto1, HttpStatus.OK);// 200
				}
			}
		}
		return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);// 400
	}

	@RequestMapping(value = "/getActiveProjectMasterList", method = RequestMethod.GET)
	public ResponseEntity<?> getActiveProjectMasterList() {
		ProjectMasterDto projectMasterDto = new ProjectMasterDto();

		boolean status = projectMasterService.getActiveProjectMasterListService(projectMasterDto);
		if (status) {
			return new ResponseEntity<>(projectMasterDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "deleteProjectMasterDetailsById", method = RequestMethod.POST)
	public ResponseEntity<?> deleteProjectMasterById(@RequestBody ProjectMasterDto projectMasterDto) {
		boolean status = projectMasterService.deleteProjectMasterByIdService(projectMasterDto);
		if (status) {
			projectMasterService.getProjectMasterListService(projectMasterDto);
			return new ResponseEntity<>(projectMasterDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value="/deleteProjectAvailabilityDetailsByParentId",method=RequestMethod.POST)
	public ResponseEntity<?> deleteProjectAvailabilityDetailsByParentId(@RequestBody ProjectMasterDto projectMasterDto){
		   
		if (projectMasterDto.getProjectId() == 0) {
			projectMasterService.getProjectMasterListService(projectMasterDto);
			return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);// 400
		} else {
			projectMasterService.deleteProjectAvailabilityDetailsByParentIdService(projectMasterDto);
			projectMasterService.getProjectMasterListService(projectMasterDto);
			return new ResponseEntity<>(projectMasterDto,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/getProjectAvailabilityListByprojectId", method = RequestMethod.POST)
	public ResponseEntity<?> getProjectAvailabilityListByprojectId(@RequestBody ProjectMasterDto projectMasterDto) {
		System.out.println("***************Project Id******************" + projectMasterDto.getProjectId());
          
		boolean status=projectMasterService.getProjectAvailabilityListByprojectIdService(projectMasterDto);
		if(status){
			//System.out.println("Number of records"+projectMasterDto.getNumberOfAvailabilityRecords());
			return new ResponseEntity<>(projectMasterDto,HttpStatus.OK);
		}
		return new ResponseEntity<>(projectMasterDto, HttpStatus.BAD_REQUEST);
	}
}
