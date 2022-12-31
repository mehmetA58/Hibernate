package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // DB den bilgi almak için 3 yol :
        // 1) get()
        // 2) SQL
        // 3) HQL

        // 1.yol : get() *************************************************************
//            Student01 student1 = session.get(Student01.class, 1001);
//            Student01 student2 = session.get(Student01.class, 1002);
//            Student01 student3 = session.get(Student01.class, 1003);
//            System.out.println(student1);
//            System.out.println(student2);
//            System.out.println(student3);

        // 2.yol: SQL *****************************************************************
//        String sqlQuery = "SELECT * FROM t_student01";
//        List<Object[]> resultList =  session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] object: resultList) {
//            System.out.println(Arrays.toString(object));
//        }

        // 3.yol : HQL ****************************************************************
        // Trick : HQL sorgusunda FRoM dan sonra sınıf ismi kullanılmalı
//        String hqlQuery ="FROM Student01";
//        List<Student01> resultList2 =  session.createQuery(hqlQuery, Student01.class).getResultList();
//        for (Student01 student01: resultList2 ) {
//            System.out.println(student01);
//        }

        // uniqueResult() with SQL **********************************************************************************
        // Dönecek kaydın unique( tek bir tane) olduğundan emin iseniz uniqueResult() methodu kullanılabilir
//        String sqlQuery2 ="SELECT * FROM t_student01 WHERE student_name='Tarık'";
//        Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        System.out.println(Arrays.toString(uniqueResult1));
//
//        // yukarda 1 obje gelecek ama içinde kolonlar olduğu için array türünde obje geldi
//        System.out.println(uniqueResult1[0] + " : "+ uniqueResult1[1] + " : " + uniqueResult1[2]);

        // uniqueResult() with HQL **********************************************************************************
        String hqlQuery2 ="FROM Student01 WHERE name='Tarık'";
        Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println(uniqueResult2);

        //********************************************************************************************

        tx.commit();

        session.close();
        sf.close();
    }
}
