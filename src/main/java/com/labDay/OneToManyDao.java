/*
 A DATA ACCESS OBJECT class to perform  encapsulating the details of the persistence layers and CRUD interface for single entity
 */
package com.labDay;
//importing required packages
import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDao {
	
	//creating global variable
	Configuration cfg;
	SessionFactory  sf;
	Session ss;
	Transaction tx ;
	
	
//First Method-> To make connection
	   public void connect() {
	    //activating Hibernate Framework
	  	  Configuration cfg = new Configuration().configure().addAnnotatedClass(student.class).addAnnotatedClass(laptop.class);
	    //buildSessionFactory() method gathers the meta-data which is in the cfg Object.
		  SessionFactory sf = cfg.buildSessionFactory();
	   //opening the Connection/Session with Database software through Hibernate Framework.
		 Session ss = sf.openSession();
				
		  Transaction tx =ss.beginTransaction();
	   }
	

//Second Method-> to add student in the database
		public Session registerSdt(student s){
			ss.save(s);
			return ss;
		}
		
//Third Method -> to add laptop in the database
		public Session registerLap(laptop sdtLaptop) {
			ss.save (sdtLaptop);
			return ss;
		}
		
// Fourth Method-> to fetch student data via sdtId
		public student fetchSdt(int id) {
		     //fetching data using session.load
			 student s = (student) ss.load(student.class, id);
			 return s;
		}
// Fifth Method-> to fetch laptop data via lapId				
		public laptop fetchLap(int id) {
			     //fetching data using session.load
				laptop sdtLaptop = (laptop) ss.load(laptop.class,id);
			    return sdtLaptop;
		}		
//sixth method-> to delete student from database via sdtId
		public int dltSdt(int id) {
			Query q = ss.createQuery("delete from student s where s.sdtId=: Id").setParameter("Id", id);
			int count = q.executeUpdate();
			return count;
		}
//Last Method-> to Disconnect the method to end
		   public void disconnect() {
				tx.commit();
				ss.close();
			}

}
