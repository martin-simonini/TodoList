
package util;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.Task;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBUtils
{

	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory()
	{
		if ( sessionFactory != null )
		{
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings( configuration.getProperties() );
		sessionFactory = configuration.buildSessionFactory( builder.build() );
		return sessionFactory;
	}
	
	public static List<Task> getAllTasks()
	{
		System.out.println("[DEBUG] Beginning getAllTasks()");
		List<Task> result = new ArrayList<Task>();
		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			List<?> tasks = session.createQuery( "FROM Task" ).list();
			
			for(Iterator<?> i = tasks.iterator(); i.hasNext();)
			{
				Task next = (Task) i.next();
				//System.out.printf("<Task> Name: %s, Description: %s \n", next.getName(), next.getDescription());
				result.add( next );
			}
			
			tx.commit();
		}
		catch(HibernateException hbe)
		{
			if( tx != null)
				tx.rollback();
			System.out.println("[ERROR][BDUtils.getAllTasks]: "+hbe.getMessage());
			hbe.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return result;
	}
	
	public static void createTask(String name, String description, Date dueDate, String tag)
	{
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			session.save( new Task(name, description, dueDate, tag) );
			tx.commit();
		}
		catch(HibernateException hbe)
		{
			if( tx != null)
				tx.rollback();
			System.out.println("[ERROR][BDUtils.createTask]: "+hbe.getMessage());
			hbe.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	public static void deleteTask(Integer id)
	{
		System.out.println("[DEBUG] Beginning deleteTask(id = "+id+")");
		
		String del = "DELETE FROM Task WHERE id="+id;
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Query q = session.createQuery(del);
			q.executeUpdate();
			
			tx.commit();
		}
		catch(HibernateException hbe)
		{
			if( tx != null)
				tx.rollback();
			System.out.println("[ERROR][BDUtils.deleteTask]: "+hbe.getMessage());
			hbe.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
	}
}
