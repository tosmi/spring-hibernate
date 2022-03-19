package at.stderr.at.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import at.stderr.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
		System.out.println("Create new student objects...");
		try {
			for(int i = 1; i <= 3; i++) {
				Session session = factory.getCurrentSession();
					Student tempStudent = new Student("StudentFirst" + i, "StudendLast" + i, "student" + i + "@stderr.at");
					session.beginTransaction();
			
					System.out.println("Saving student " + i + " ...");
					session.save(tempStudent);
					
					session.getTransaction().commit();
					System.out.println("Done!");
			}
		}
		finally {
			factory.close();
		}
	}
}
