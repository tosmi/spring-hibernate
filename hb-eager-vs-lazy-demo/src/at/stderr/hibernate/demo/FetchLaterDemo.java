package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Course;
import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchLaterDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // start the transaction
            session.beginTransaction();

            // option 2: hibernate query with HQL

            // get instructor from database
            int theID = 1;
            Instructor tempInstructor = session.get(Instructor.class, theID);

            System.out.println("luv2code: Instructor: " + tempInstructor);

            // commit transaction
            session.getTransaction().commit();
            session.close();

            System.out.println("\nThe session is now closed!\n");

            // get courses for the instructor
            System.out.println("\nOpening a new session!\n");
            // start a new session
            session = factory.getCurrentSession();
            session.beginTransaction();

            // execute query and get instructor
            Query<Course> query =
                    session.createQuery("select c from Course c "
                                    + "where c.instructor.id = :theInstructorId",
                            Course.class);

            // set parameter on query
            query.setParameter("theInstructorId", theID);

            List<Course> tempCourses = query.getResultList();

            session.getTransaction().commit();

            System.out.println("luv2code: Courses: " + tempCourses);

            System.out.println("luv2code: Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
