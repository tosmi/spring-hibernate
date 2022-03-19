package at.stderr.at.hibernate.demo;

import at.stderr.hibernate.demo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;

			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Getting student with ID: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get complete: " + myStudent);

//			System.out.println("Deleting student " + myStudent);
//			session.delete(myStudent);

			session.createQuery("delete from Student where firstName like 'StudentFirst%'")
							.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
