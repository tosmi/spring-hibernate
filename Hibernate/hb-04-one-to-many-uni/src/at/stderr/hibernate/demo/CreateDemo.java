package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create the objects
//            Instructor tempInstructor =
//                    new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//            InstructorDetail tempInstructorDetail =
//                    new InstructorDetail(
//                            "http://www.luv2code.com/youtube",
//                            "Luv 2 Code!!"
//                    );

            Instructor tempInstructor =
                    new Instructor("Madhu", "Patel", "madhu@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.youtube.com",
                            "Guitar"
                    );

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            // save the instructor
            // NOTE: this will also save the details object
            // because of CascadeType.ALL
            System.out.println("Saving instructor " + tempInstructor);
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
