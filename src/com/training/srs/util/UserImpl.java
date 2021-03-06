package com.training.srs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.srs.bean.CredentialsBean;
import com.training.srs.bean.ProfileBean;
import com.training.srs.exception.ShipException;
@Repository
public class UserImpl implements User{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	IdGenerator idgenrate;
	@Override
	public String login(CredentialsBean credentialsBean) throws ShipException {
		try{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from CredentialsBean where userID=:id");
		query.setParameter("id", credentialsBean.getUserID());
		CredentialsBean credential=(CredentialsBean) query.uniqueResult();
		if(credential.getPassword().equals(credentialsBean.getPassword()) && credential.getUserType().equals(credentialsBean.getUserType())) {
			 credential.setLoginStatus(1);
			 session.update(credential);
			session.getTransaction().commit();
			return credentialsBean.getUserType();	
		}
		else {
			return "INVALID";
		}
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
		
	}

	@Override
	public boolean logout(String userId) throws ShipException {
		try{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from CredentialsBean where userID=:id");
		query.setParameter("id", userId);
		CredentialsBean credential=(CredentialsBean) query.uniqueResult();
		credential.setLoginStatus(0);
		session.update(credential);
		session.getTransaction().commit();
		session.close();
		return true;
		}
		catch (Exception e) {
			throw new ShipException(e.getMessage());
		}
	}

	@Override
	public String changePassword(String userID, String newPassword) throws ShipException {
		try{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Query query=session.createQuery("from CredentialsBean where userID=:id");
			query.setParameter("id", userID);
			CredentialsBean credential=(CredentialsBean) query.uniqueResult();
			credential.setPassword(newPassword);
			session.update(credential);
			Query query1=session.createQuery("from ProfileBean where userID=:id");
			query1.setParameter("id", userID);
			ProfileBean profile=(ProfileBean) query1.uniqueResult();
			profile.setPassword(newPassword);
			session.update(profile);
			session.getTransaction().commit();
			session.close();
			return "Success";
		}catch (Exception e) {
				throw new ShipException(e.getMessage());
			}
	}

	@Override
	public String register(ProfileBean profileBean) throws ShipException {
		try{
			
			
			
			profileBean.setUserID(idgenrate.idGenerate(profileBean.getFirstName()));

			CredentialsBean credinals=new CredentialsBean();
			credinals.setUserID(profileBean.getUserID());
			credinals.setPassword(profileBean.getPassword());
			credinals.setLoginStatus(0);
			credinals.setUserType("C");
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		addCredinals(credinals);
		session.save(profileBean);
		session.getTransaction().commit();
		session.close();
		return profileBean.getUserID();
		}
		catch(Exception e) {
			throw new ShipException(e.getMessage());
		}
		
	}
	public boolean addCredinals(CredentialsBean credinals) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(credinals);
		session.getTransaction().commit();
		session.close();
		return true;
		
	}

	@Override
	public String validateNumber(String userID,String mobileNo) throws ShipException {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from ProfileBean where userID=:id");
			query.setParameter("id", userID);
			ProfileBean profile=(ProfileBean) query.uniqueResult();
			if(profile.getMobileNo().equals(mobileNo))
				return "Valid";
			else 
				return "Fail";
			}
			catch (Exception e) {
				throw new ShipException(e.getMessage());
			}
		}
	

	
	
}
