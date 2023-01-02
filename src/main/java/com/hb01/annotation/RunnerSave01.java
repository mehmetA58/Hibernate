package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Samet Güler");
        student1.setGrade(90);

        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("Tarık");
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Miraç");
        student3.setGrade(70);

        Student01 student4=new Student01();
        student4.setId(1905);
        student4.setName("Mehmet");
        student4.setGrade(100);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        // yukardaki satırda , Hibernate 'e konfigürasyon dosyamı ve Entity clasımı bildirdim.
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//         session.save(student1);
//         session.save(student2);
//         session.save(student3);
//           session.save(student4);

        tx.commit(); // commit yapılmazsa DB ye bigileriniz gitmez

        session.close();  //Session close edilmeli, edilmezse connection açık kalır.
        sf.close();


    }
}
