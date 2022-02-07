package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get instructor by primary key
            int theId = 3;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Found inststructor:" + tempInstructor);

            if(tempInstructor != null) {
                System.out.println("Deleting: " + tempInstructor);

                // will also delelte the details object
                // because of CascadeType.ALL
                session.delete(tempInstructor);
            }

            // commit transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
