package com.training.srs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.srs.bean.ScheduleBean;
import com.training.srs.bean.ShipBean;
import com.training.srs.exception.ShipException;
import com.training.srs.util.IdGenerator;
@Repository
public class ShipDaoImpl implements ShipDao {
	@Autowired
	IdGenerator gen;
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String createShip(ShipBean shipBean) throws ShipException {
		try {
			shipBean.setShipID(gen.idGenerate(shipBean.getShipName()));
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(shipBean);
			session.getTransaction().commit();
			session.close();
			return "SUCCESS";
			}
			catch(Exception e) {
				throw new ShipException(e.getMessage());
			}
	}

	@Override
	public int deleteShip(String id) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Query query=session.createQuery("from ShipBean where shipId=:id");
			query.setParameter("id",id);
			ShipBean shipBean=(ShipBean) query.uniqueResult();
			session.delete(shipBean);
			session.getTransaction().commit();
			return 1;
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public boolean updateShip(ShipBean shipBean) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.update(shipBean);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public ShipBean findShipByID(String id) throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("select from RouteBean where routeId=:id");
			query.setParameter("id",id);
			return (ShipBean) query.uniqueResult();
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
		
	}

	@Override
	public ArrayList<ShipBean> findAllShips() throws ShipException {
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from ShipBean");
			ArrayList<ShipBean> ships=(ArrayList<ShipBean>) query.getResultList();
			return ships ;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public ArrayList<ShipBean> findShipsBySD(String source, String destination) throws ShipException {
		try {
			ArrayList<ShipBean> ships=new ArrayList<ShipBean>();
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("select routeID from RouteBean where source=:s and destination=:d");
			query.setParameter("s", source);
			query.setParameter("d", destination);
			String routeId=(String) query.uniqueResult();
			Query query1=session.createQuery("select shipID from ScheduleBean where routeID=:id");
			query1.setParameter("id", routeId);
			List<String> shipIds=(List<String>) query1.getResultList();
			for (String shipId : shipIds) {
				Query query2=session.createQuery("from ShipBean where shipID=:id");
				query2.setParameter("id", shipId);
				ShipBean ship=(ShipBean) query2.uniqueResult();
				ships.add(ship);
			}
			
			return ships ;
			
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	

	

}
