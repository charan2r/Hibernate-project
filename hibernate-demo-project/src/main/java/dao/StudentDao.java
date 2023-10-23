package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Student;
import util.HibernateUtil;

public class StudentDao implements IStudentDao {

	@SuppressWarnings("deprecation")
	public void saveStudent(Student student) {
	     Transaction transaction = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 // start the transaction
		     transaction = session.beginTransaction();
		     
		     // save student object
		     session.save(student);
		     
		     // commit the transaction
		     transaction.commit();    
		 } 
		 catch (Exception e) {
		 if (transaction != null) {
		      transaction.rollback();
		    }
	     }	
	}

	@SuppressWarnings("deprecation")
	public void updateStudent(Student student) {
		 Transaction transaction = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 // start the transaction
		     transaction = session.beginTransaction();
		     // save student object
		     session.saveOrUpdate(student);
		     // commit the transaction
		     transaction.commit();
		     
		 } 
		 catch (Exception e) {
		 if (transaction != null) {
		    transaction.rollback();
		   }
		 }
	}

	public Student getStudentById(long id) {
		 Transaction transaction = null;
		 Student student = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 // start the transaction
		     transaction = session.beginTransaction();
		     
		     // get student object
		     student = session.get(Student.class, id);
		     
		     //student = session.load(Student.class, id);
		     // commit the transaction
		     transaction.commit();
		     
		 } 
		 catch (Exception e) {
		 if (transaction != null) {
		      transaction.rollback();
		   }
		 }
		 return student;
	}
	
	
	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Student> getAllStudents() {
		 Transaction transaction = null;
		 List < Student > students = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 // start the transaction
		     transaction = session.beginTransaction();
		     
		     // get students
		     students = session.createQuery("from Student").list();
		     
		     //student = session.load(Student.class, id);
		     // commit the transaction
		     transaction.commit();
		     
		 } 
		 catch (Exception e) {
		 if (transaction != null) {
		      transaction.rollback();
		    }
		 }
		 return students;
	}

	@SuppressWarnings("deprecation")
	public void deleteStudent(long id) {
		 Transaction transaction = null;
		 Student student = null;
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		 
			 // start the transaction
		     transaction = session.beginTransaction();
		     student = session.get(Student.class, id);
		     
		     // get student object
		     session.delete(student);
		     
		     //student = session.load(Student.class, id);
		     // commit the transaction
		     transaction.commit();
		     
		 } 
		 catch (Exception e) {
		 if (transaction != null) {
		      transaction.rollback();
		    }
		 }
	}
	
	
	
}
