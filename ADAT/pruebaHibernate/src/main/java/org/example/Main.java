package org.example;

import com.mysql.cj.xd evapi.SessionFactory;
import org.hibernate.*;
public class Main {
    public static void main(String[] args) {

        SessionFactory sesion = HibernateUtil.getSessionfactory();
    }
}