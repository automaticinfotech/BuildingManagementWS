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

import com.aits.dao.ProjectMasterDao;
import com.aits.model.ProjectMaster;

@Repository("ProjectMasterDao")
public class ProjectMasterDaoImplementation implements ProjectMasterDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean getProjectMasterDaoList(ProjectMaster projectMaster) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectMaster.class);
		List<ProjectMaster> projectMasterDaoList = criteria.list();
		if (!projectMasterDaoList.isEmpty()) {
			projectMaster.setProjectMasterList(projectMasterDaoList);
			return true;
		}

		return false;
	}

	@Override
	public boolean isProjectExistDao(ProjectMaster projectMaster) {
		System.out.println("Inside Dao" + projectMaster.getProjectName());
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectMaster.class);
		Criterion criterion = Restrictions.eq("projectName", projectMaster.getProjectName());
		criteria.add(criterion);
		ProjectMaster projectMasterDaoResult = (ProjectMaster) criteria.uniqueResult();
		if (projectMasterDaoResult != null) {
			System.out.println("Dao result name==" + projectMasterDaoResult.getProjectName());
			if (projectMaster.getProjectName().equalsIgnoreCase(projectMasterDaoResult.getProjectName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean insertProjectMasterDetailsDao(ProjectMaster projectMaster) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Integer primaryKey = (Integer) session.save(projectMaster);
		transaction.commit();
		if (primaryKey.equals(null)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean findProjectMasterDetailsById(ProjectMaster projectMaster) {
		System.out.println("Inside Dao" + projectMaster.getProjectId());
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectMaster.class);
		Criterion criterion = Restrictions.eq("projectId", projectMaster.getProjectId());
		criteria.add(criterion);
		ProjectMaster projectMasterDaoResult = (ProjectMaster) criteria.uniqueResult();
		if (projectMasterDaoResult != null) {
			//System.out.println("Dao result name==" + projectMasterDaoResult.getProjectName());
             projectMaster.setProjectName(projectMasterDaoResult.getProjectName());
             projectMaster.setProjectIsActive(projectMasterDaoResult.getProjectIsActive());
			return true;

		}
		return false;

	}

	@Override
	public boolean editProjectMasterById(ProjectMaster projectMaster) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(projectMaster);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean inactivateProjectMasterDetailsById(ProjectMaster projectMaster) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(projectMaster);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean getActiveProjectMasterDaoList(ProjectMaster projectMaster) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectMaster.class);
		Criterion criterion=Restrictions.eq("projectIsActive", "A");
		criteria.add(criterion);
		List<ProjectMaster> projectMasterDaoList = criteria.list();
		if (!projectMasterDaoList.isEmpty()) {
			projectMaster.setProjectMasterList(projectMasterDaoList);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteProjectMasterById(ProjectMaster projectMaster) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(projectMaster);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean isProjectExistDaoForUpdate(ProjectMaster projectMaster) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProjectMaster.class);
		Criterion criterion = Restrictions.eq("projectName", projectMaster.getProjectName());
		criteria.add(criterion);
		ProjectMaster projectMasterDaoResult = (ProjectMaster) criteria.uniqueResult();
		if (projectMasterDaoResult != null) {
			System.out.println("Dao result name==" + projectMasterDaoResult.getProjectName());
			if ( projectMaster.getProjectId()!=projectMasterDaoResult.getProjectId()&&
					projectMaster.getProjectName()
					.equalsIgnoreCase(projectMasterDaoResult
							.getProjectName())) {
				return true;
			}
		}
		return false;
	}

}
