package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Course;
import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

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

            // get a course
            int theID = 1;
            var theCourse = session.get(Course.class, theID);

            // delete the course
            System.out.println("Deleting course: " + theCourse);

            session.delete(theCourse);
            // commit transaction
            session.getTransaction().commit();

            System.out.printf("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
