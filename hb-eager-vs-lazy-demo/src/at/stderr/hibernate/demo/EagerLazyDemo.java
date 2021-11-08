package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Course;
import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create the objects

            // start the transaction
            session.beginTransaction();

            // get instructor from database
            int theID = 1;
            Instructor tempInstructor = session.get(Instructor.class, theID);

            System.out.println("luv2code: Instructor: " + tempInstructor);

            // get courses for the instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            System.out.printf("luv2code: Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
