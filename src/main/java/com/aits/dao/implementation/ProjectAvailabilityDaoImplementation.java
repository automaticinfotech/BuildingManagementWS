package com.aits.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aits.dao.ProjectAvailabilityDao;
import com.aits.dto.ProjectAvailabilityDto;
import com.aits.model.ProjectAvailability;

@Repository("ProjectAvailabilityDao")
public class ProjectAvailabilityDaoImplementation implements ProjectAvailabilityDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean getProjectAvailabilityDaoList(ProjectAvailability projectAvailability) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectAvailability.class);
		List<ProjectAvailability> projectAvailabilityDaoList = criteria.list();
		if (!projectAvailabilityDaoList.isEmpty()) {
			projectAvailability.setProjectAvailabilityList(projectAvailabilityDaoList);
			return true;
		}

		return false;
	}

	@Override
	public boolean insertProjectAvailabilityDetailsDao(ProjectAvailability projectAvailability) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Integer primaryKey = (Integer) session.save(projectAvailability);
		transaction.commit();
		if (primaryKey.equals(null)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean editProjectAvaialabilityById(ProjectAvailability projectAvailability) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(projectAvailability);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean findProjectMasterDetailsById(ProjectAvailability projectAvailability) {
		System.out.println("Inside Dao" + projectAvailability.getAvailabilityId());
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectAvailability.class);
		Criterion criterion = Restrictions.eq("availabilityId", projectAvailability.getAvailabilityId());
		criteria.add(criterion);
		ProjectAvailability projectAvailabilityDaoResult = (ProjectAvailability) criteria.uniqueResult();
		if (projectAvailabilityDaoResult != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProjectMasterDetailsById(ProjectAvailability projectAvailability) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(projectAvailability);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean getProjectAvailabilityByIdDaoList(ProjectAvailability projectAvailability) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectAvailability.class).add(Restrictions.eq("projectMaster",projectAvailability.getProjectMaster()));
		List<ProjectAvailability> projectAvailabilityDaoList = criteria.list();
		if (!projectAvailabilityDaoList.isEmpty()) {
			projectAvailability.setProjectAvailabilityList(projectAvailabilityDaoList);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean isProjectAvailabilityExist(ProjectAvailability projectAvailability,ProjectAvailabilityDto projectAvailabilityDto) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectAvailability.class);
		Criterion criterion = Restrictions.eq("wingName", projectAvailability.getWingName());
		criteria.add(criterion).add(Restrictions.eq("floorNumber", projectAvailability.getFloorNumber())).add(Restrictions.eq("OfficeNumber", projectAvailability.getOfficeNumber())).add(Restrictions.eq("areaSquareFoot", projectAvailability.getAreaSquareFoot())).add(Restrictions.eq("projectMaster", projectAvailability.getProjectMaster()));
		ProjectAvailability projectAvailabilityDaoResult = (ProjectAvailability) criteria.uniqueResult();
		
		if (projectAvailabilityDaoResult != null) {
			projectAvailabilityDto.setAvailabilityId(projectAvailabilityDaoResult.getAvailabilityId());
		    return true;
		}
		return false;
	}

	@Override
	public boolean getProjectAvailabilityByAvailabilityId(ProjectAvailabilityDto projectAvailabilityDto) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectAvailability.class).add(Restrictions.eq("availabilityId",projectAvailabilityDto.getAvailabilityId()));
		ProjectAvailability projectAvailability = (ProjectAvailability)criteria.uniqueResult();
		if (projectAvailability!=null) {
			
			projectAvailabilityDto.setAvailabilityId(projectAvailability.getAvailabilityId());
			projectAvailabilityDto.setAreaSquareFoot(projectAvailability.getAreaSquareFoot());
			projectAvailabilityDto.setFloorNumber(projectAvailability.getFloorNumber());
			projectAvailabilityDto.setOfficeNumber(projectAvailability.getOfficeNumber());
			projectAvailabilityDto.setIsActive(projectAvailability.getIsActive());
			projectAvailabilityDto.setWingName(projectAvailability.getWingName());
			projectAvailabilityDto.setProjectMaster(projectAvailability.getProjectMaster());
			return true;
		}
		return false;
	}

}