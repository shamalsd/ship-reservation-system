package com.training.srs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.srs.bean.PassengerBean;
import com.training.srs.bean.ScheduleBean;
import com.training.srs.exception.ShipException;
import com.training.srs.util.IdGeneratorSD;
import com.training.srs.util.IdSchdGenerator;
@Repository
public class ScheduleDaoImpl implements ScheduleDao{
	@Autowired
	IdSchdGenerator sch;
	@Autowired
	IdGeneratorSD gen;
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String createSchedule(ScheduleBean scheduleBean) throws ShipException {
		try {
			scheduleBean.setScheduleID(sch.idGenerateSch(scheduleBean.getRouteID()));
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(scheduleBean);
			session.getTransaction().commit();
			session.close();
			return "SUCCESS";
			}
			catch(Exception e) {
				throw new ShipException(e.getMessage());
			}
	}

	@Override
	public int deleteSchedule(String id) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("delete from ScheduleBean where scheduleId=:id");
			query.setParameter("id",id);
			query.executeUpdate();
			return 1;
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public boolean updateSchedule(ScheduleBean scheduleBean) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(scheduleBean);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public ScheduleBean findScheduleByID(String id) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("select from ScheduleBean where scheduleId=:id");
			query.setParameter("id",id);
			return (ScheduleBean) query.uniqueResult() ;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public ArrayList<ScheduleBean> findAllSchedules() throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from ScheduleBean");
			ArrayList<ScheduleBean> schedules=(ArrayList<ScheduleBean>) query.getResultList();
			return schedules ;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public ArrayList<PassengerBean> viewPasengersByShip(String scheduleId) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from PassengerBean where scheduleId=:id");
			query.setParameter("id", scheduleId);
			
			ArrayList<PassengerBean> passengers=(ArrayList<PassengerBean>) query.getResultList();
			return passengers ;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	
	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date)
			throws ShipException {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select routeId from RouteBean where source=:s and destination=:d ");
		query.setParameter("s", source);
		query.setParameter("d", destination);

		List<String> routeIds=query.list();
		ArrayList<ScheduleBean> schedules=new ArrayList<ScheduleBean>();
		for (String rd : routeIds) {
			Query query1=session.createQuery("from ScheduleBean where routeId=:rd and startDate=:dt ");
			query1.setParameter("rd", rd);
			query1.setParameter("dt", date);
			schedules.addAll(query1.getResultList());
		}	
		return schedules;
	}

	@Override
	public ArrayList<ScheduleBean> findScheduleBySD(String source, String destination) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("select routeID from RouteBean where source=:s and destination=:d");
			query.setParameter("s", source);
			query.setParameter("d", destination);
			String routeId=(String) query.uniqueResult();
			Query query1=session.createQuery(" from ScheduleBean where routeID=:id");
			query1.setParameter("id", routeId);
			ArrayList<ScheduleBean> schedules=(ArrayList<ScheduleBean>) query1.getResultList();
			return schedules ;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}

	}
}
