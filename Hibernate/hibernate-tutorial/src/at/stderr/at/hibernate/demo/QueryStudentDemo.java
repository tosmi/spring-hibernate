package at.stderr.at.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import at.stderr.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();

			List<Student> theStudents = session.createQuery("from Student").getResultList();
			System.out.println("display all students");			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName = 'Duck'").getResultList();
			System.out.println("\n\nselect by lastname");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where "
					+ "s.lastName = 'Duck' or s.firstName ='Paul' ").getResultList();
			System.out.println("\n\nselect by lastname or firstname");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where "
					+ "s.lastName like 'Studend%'").getResultList();
			System.out.println("\n\nselect with like");
			displayStudents(theStudents);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

	static void displayStudents(List<Student> theStudents) {
		for(Student tmpStudent : theStudents ) {
			System.out.println(tmpStudent);
		}
	}

}
