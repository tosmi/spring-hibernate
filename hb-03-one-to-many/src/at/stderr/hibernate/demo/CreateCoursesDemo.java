package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Course;
import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

            // create some courses
            Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
            Course tempCourse2 = new Course("The Pinball Masterclass");

            // add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            // save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);

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
