package org.example.modeloVentas;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Ej3_6 {
    static Session s;
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        s = sf.openSession();
        insertaCliente(s);
        Transaction t = s.beginTransaction();
        Clientes c = new Clientes();
        c.setId(56);
        c.setNombre("Antonio");
        c.setNif("12345678W");
        s.save(c);
        t.commit();
        s.close();
    }

    private static void insertaCliente(Session s) {
    }
    private static boolean tieneClienteId(int id){

        return false;
    }
}
