package com.aits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aits.dto.ProjectAvailabilityDto;
import com.aits.service.ProjectAvailabilityService;

@RestController
public class ProjectAvailabilityController {
	
	@Autowired
	ProjectAvailabilityService projectAvailabilityService;

	public void setProjectAvailabilityService(ProjectAvailabilityService projectAvailabilityService) {
		this.projectAvailabilityService = projectAvailabilityService;
	}
	
	
	@RequestMapping(value="/getProjectAvailabilityList",method=RequestMethod.GET)
	public ResponseEntity<?> getProjectAvailabilityList() {
		ProjectAvailabilityDto projectAvailabilityDto = new ProjectAvailabilityDto();
		boolean status=projectAvailabilityService.getProjectAvailabilityListService(projectAvailabilityDto);
        if(status)
        return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.OK);
        
        return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value="/getProjectAvailabilityByIdList",method=RequestMethod.POST)
	public ResponseEntity<?> getProjectAvailabilityByIdList(@RequestBody ProjectAvailabilityDto projectAvailabilityDto) {
		
		boolean status=projectAvailabilityService.getProjectAvailabilityListByIdService(projectAvailabilityDto);
        if(status)
        return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.OK);
        
        return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/insertProjectAvailabilityDetails",method=RequestMethod.POST)
	public ResponseEntity<?> insertProjectAvailabilityDetails(@RequestBody ProjectAvailabilityDto projectAvailabilityDto){
		
		if (projectAvailabilityService.isProjectAvailabilityExist(projectAvailabilityDto)) {
            projectAvailabilityService.getProjectAvailabilityListService(projectAvailabilityDto);
            return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.CONFLICT);//409
        }
      
	    boolean status=projectAvailabilityService.insertProjectAvailabilityDetailsService(projectAvailabilityDto);
	     if(status){
	    	 ProjectAvailabilityDto projectAvailabilityDto1=new ProjectAvailabilityDto();
	    	 projectAvailabilityService.getProjectAvailabilityListService(projectAvailabilityDto1);
	    	 return new ResponseEntity<>(projectAvailabilityDto1,HttpStatus.CREATED);//201
	     }
        return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.BAD_REQUEST);//400
	}
	
	
	@RequestMapping(value="/editProjectAvailabilityById",method=RequestMethod.POST)
	public ResponseEntity<?> editProjectAvailabilityById(@RequestBody ProjectAvailabilityDto projectAvailabilityDto){
	
	  // projectAvailabilityService.isProjectAvailabilityExist(projectAvailabilityDto);
	   boolean status=projectAvailabilityService.editProjectAvailabilityByIdService(projectAvailabilityDto);
	   if(status){ 
		   ProjectAvailabilityDto projectAvailabilityDto1=new ProjectAvailabilityDto();
		   projectAvailabilityService.getProjectAvailabilityListService(projectAvailabilityDto1);
		   return new ResponseEntity<>(projectAvailabilityDto1,HttpStatus.OK);//200 
	   } 
	   return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.BAD_REQUEST);//400
		
	}
	
	@RequestMapping(value="/deleteProjectAvailabilityDetailsById",method=RequestMethod.POST)
	public ResponseEntity<?> deleteProjectAvailabilityDetailsById(@RequestBody ProjectAvailabilityDto projectAvailabilityDto){
		
		boolean projectStatus=projectAvailabilityService.findProjectAvailabilityDetailsByIdService(projectAvailabilityDto);
		
		if(projectStatus){
			boolean status=projectAvailabilityService.deleteProjectAvailabilityDetailsByIdService(projectAvailabilityDto);
			if(status){
				 ProjectAvailabilityDto projectAvailabilityDto1=new ProjectAvailabilityDto();
		         projectAvailabilityService.getProjectAvailabilityListService(projectAvailabilityDto1);
		         return new ResponseEntity<>(projectAvailabilityDto1,HttpStatus.OK);//200 
			}
			return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/getProjectAvailabilityByAvailabilityId",method=RequestMethod.POST)
	public ResponseEntity<?> getProjectAvailabilityByAvailabilityId(@RequestBody ProjectAvailabilityDto projectAvailabilityDto) {
		
		boolean status=projectAvailabilityService.getProjectAvailabilityByAvailabilityId(projectAvailabilityDto);
        if(status)
        return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.OK);
        
        return new ResponseEntity<>(projectAvailabilityDto,HttpStatus.BAD_REQUEST);
	}
	

}
