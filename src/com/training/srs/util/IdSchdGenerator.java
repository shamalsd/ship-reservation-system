package com.training.srs.util;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdSchdGenerator {
	@Autowired
	SessionFactory sessionFactory;
	public String idGenerateSch(String routeId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createNativeQuery("select id_seq.nextval from dual");
		BigDecimal d= (BigDecimal) query.uniqueResult();
		session.getTransaction().commit();
		//String id=str.charAt(0)+str.charAt(1)+String.valueOf(d);
		String id=routeId.substring(0, 4)+String.valueOf(d);
		session.close();
		return id;
		
	}
}
