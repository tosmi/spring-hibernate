package at.stderr.at.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import at.stderr.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create new student object...");
			Student tempStudent = new Student("Duffy", "Duck", "duffy@stderr.at");
			
			session.beginTransaction();
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			session.getTransaction().commit();
					
			System.out.println("Saved Student.Generated ID: " + tempStudent.getId());
			session = factory.getCurrentSession();	
			session.beginTransaction();
			System.out.println("Getting student with ID: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: " + myStudent);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
