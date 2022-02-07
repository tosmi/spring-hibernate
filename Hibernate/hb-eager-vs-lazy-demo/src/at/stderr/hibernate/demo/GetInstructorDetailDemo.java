package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get the instructor detail object
            int theID = 2999;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theID);

            // print instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            // print associated instructor
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor() );

            // commit transaction
            session.getTransaction().commit();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
