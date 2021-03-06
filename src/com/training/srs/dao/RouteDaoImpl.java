package com.training.srs.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.srs.bean.RouteBean;
import com.training.srs.exception.ShipException;
import com.training.srs.util.IdGenerator;
import com.training.srs.util.IdGeneratorSD;
@Repository
public class RouteDaoImpl implements RouteDao {
	@Autowired
	IdGeneratorSD gen;
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String createRoute(RouteBean routeBean) throws ShipException {
		try {
	    routeBean.setRouteID(gen.idGenerateSd(routeBean.getSource(),routeBean.getDestination()));
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(routeBean);
		session.getTransaction().commit();
		session.close();
		return "SUCCESS";
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public int deleteRoute(String id) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("delete from RouteBean where routeId=:id");
			query.setParameter("id",id);
			query.executeUpdate();
			return 1;
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
		
	}

	@Override
	public boolean updateRoute(RouteBean routeBean) throws ShipException {
		
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(routeBean);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public RouteBean findRouteByID(String id) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("select from RouteBean where routeId=:id");
			query.setParameter("id",id);
			return (RouteBean) query.uniqueResult() ;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
		
	}

	@Override
	public ArrayList<RouteBean> findAllRoutes() throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from RouteBean");
			ArrayList<RouteBean> routes=(ArrayList<RouteBean>) query.getResultList();
			return routes ;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}	
		
	}

	
}
