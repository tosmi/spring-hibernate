package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Course;
import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                            + "JOIN FETCH i.courses "
                            + "where i.id = :theInstructorId",
                            Instructor.class);

            // set parameter on query
            query.setParameter("theInstructorId", theID);

            // execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("luv2code: Instructor: " + tempInstructor);

            // commit transaction
            session.getTransaction().commit();
            session.close();

            System.out.println("\nThe session is now closed!\n");

            // get courses for the instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            System.out.println("luv2code: Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
