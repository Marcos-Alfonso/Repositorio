package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        Clientes c = new Clientes();
        c.setId((byte) 56);
        c.setNombre("Antonio");
        c.setNif("12345678W");
        s.save(c);
        t.commit();
        s.close();

    }
}