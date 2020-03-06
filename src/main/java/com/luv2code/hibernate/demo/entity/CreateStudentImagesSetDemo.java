package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.ObjectInputFilter;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class CreateStudentImagesSetDemo
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

           Student tempStudent = new Student("John", "Peterson", "john@luv2code.com");
           Set<String> theImages = tempStudent.getImages();

           theImages.add("photo1.jpg");
           theImages.add("photo2.jpg");
           theImages.add("photo3.jpg");
           theImages.add("photo4.jpg");
           theImages.add("photo4.jpg");
           theImages.add("photo5.jpg");
           theImages.add("photo5.jpg");

           //start transaction
           session.beginTransaction();

           //save the object
           System.out.println("Saving the student and images..");
           session.persist(tempStudent);

           //commit transaction
           session.getTransaction().commit();
           System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
