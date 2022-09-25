/*
 * A Simple project to illustrate one to many mapping using hibernate , dao and hql and performing some CRUD operations 
 * One Student having many Laptops
 * @Divya
 */
package com.labDay;
//importing required packages
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class mainHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//creating scanner object
    	Scanner obj = new Scanner(System.in);
    	int id,ram,n;
    	int op=0;
    	String name,domain,email,contact,os;
    	List<laptop> lapList = new ArrayList<laptop>();
    	List<student> sdtList = new ArrayList<student>();
    	
    	//creating student class object to communicate with the same
    	student s = new student();
    	//creating laptop class object to communicate
    	laptop sdtLaptop = new laptop();
    	//creating one to manydao class object to communication
    	OneToManyDao dao = new OneToManyDao();
    	
    	while(op<6)
    	{
    	out.println("\nPress 1 - ***To Add STUDENT \nPress 2 - ***To Add LAPTOP \nPress 3 - ***To Print STudent \nPress 4 - ***To Print LAPTOP \nPress 5 - ***TO Delete STUDENT \nPress 6 - ***TO Exit");
    	out.println("\nEnter Your Choice : ");
    	op = obj.nextInt();
    	
    	switch(op) {
		
		// first case-> to establish one to many mappings
		case 1->{
			
			out.print("Enter Name -> ");
			name = obj.next();
			s.setSdtName(name);
			out.print("Enter Domain Name -> ");
			domain = obj.next();
			s.setSdtDomain(domain);
		    out.print("Enter Email -> ");
			email = obj.next();
			s.setSdtEmail(email);
			out.print("Enter Contact No -> ");
			contact = obj.next();
			s.setSdtContact(contact);
			out.print("\nEnter How many laptop -> ");
			n = obj.nextInt();
			dao.connect();
			//for loop for taking input 
			for(int i = 1;i<=n;i++) {
				laptop lappi = new laptop();
				out.print("Enter "+i+" Laptop  Name   -> ");
				name = obj.next();
				lappi.setLapName(name);
				out.print("Enter "+i+" Laptop  RAM   ->");
				ram = obj.nextInt();
				lappi.setLapRAM(ram);
				out.print("Enter "+i+" Operating System  -> ");
				os = obj.next();
				lappi.setLapOs(os);
				dao.registerLap(lappi);
				lapList.add(lappi); 
			}
			//printing the details in laplist
			s.setSdtLaptop(lapList);
			//calling register method
			dao.registerSdt(s);
			//calling disconnect method
			dao.disconnect();
			
		}
		
		
		// Second case -> to fetch a student via primary key (sdtId)
		case 2->{
			out.print("\nEnter Id : ");
			id = obj.nextInt();
			//calling connecting method
			dao.connect();
			s=dao.fetchSdt(id);
			out.println(s);
			dao.disconnect();
		}
		
		// third case -> to fetch laptop using primary key
		case 3->{
			out.print("\nEnter Id : ");
			id = obj.nextInt();
			//calling connect method
			dao.connect();
			sdtLaptop = (laptop) dao.fetchLap(id);
			out.println(sdtLaptop);
			dao.disconnect();
		}
		
		// fourth case -> to delete a student from database
		case 4->{
			out.print("\nEnter Id : ");
			id = obj.nextInt();
			dao.connect();
			n=dao.dltSdt(id); 
			if(n==1)
				out.println("Student Deleted.");
			else
				out.println("Student does not exist.");
			dao.disconnect();
		}
		
		}
	}
	
	//closing scanner object
	obj.close();	
    	
    	}
  

}
