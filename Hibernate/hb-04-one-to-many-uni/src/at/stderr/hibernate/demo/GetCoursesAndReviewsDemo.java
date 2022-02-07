package at.stderr.hibernate.demo;

import at.stderr.hibernate.demo.entity.Course;
import at.stderr.hibernate.demo.entity.Instructor;
import at.stderr.hibernate.demo.entity.InstructorDetail;
import at.stderr.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesAndReviewsDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int theId = 1;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}